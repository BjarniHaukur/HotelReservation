package hotelreservation.data;

import hotelreservation.entities.Hotel;
import hotelreservation.entities.Room;
import hotelreservation.entities.Info;
import hotelreservation.entities.Reservation;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class HotelDataConnection {
    private Connection conn = null;
    // private final DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static HotelDataConnection instance = null;

    public HotelDataConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:HotelData.db");
            initializeDatabaseFromScript();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            closeConnection();
        }
    }

    public static HotelDataConnection getInstance(){
        if(instance == null){
            instance = new HotelDataConnection();
        }
        return instance;
    }

    private void getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:HotelData.db");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    private void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void initializeDatabaseFromScript() throws Exception {
        InputStream scriptStream = null;
        // ApplicationDirectory returns the private read-write sandbox area
        // of the mobile device's file system that this application can access.
        // This is where the database is created
        String dbName = "HotelData.db";

        // Verify whether or not the database exists.
        // If it does, then it has already been initialized
        // and no further actions are required
        File dbFile = new File(dbName);
        if (dbFile.exists())
            return;

        String current = System.getProperty("user.dir");
        // Since the SQL script has been packaged as a resource within
        // the application, the getResourceAsStream method is used
        scriptStream = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("META-INF/initialize.sql");
        BufferedReader scriptReader = new BufferedReader(new FileReader(current + "/hotelreservation/data/database.sql"));
        String nextLine;
        StringBuffer nextStatement = new StringBuffer();

        // The while loop iterates over all the lines in the SQL script,
        // assembling them into valid SQL statements and executing them as
        // a terminating semicolon is encountered
        Statement stmt = conn.createStatement();
        while ((nextLine = scriptReader.readLine()) != null) {
            // Skipping blank lines, comments, and COMMIT statements
            if (nextLine.startsWith("REM") ||
                    nextLine.startsWith("COMMIT") ||
                    nextLine.length() < 1)
                continue;
            nextStatement.append(nextLine);
            if (nextLine.endsWith(";")) {
                stmt.execute(nextStatement.toString());
                nextStatement = new StringBuffer();
            }
        }
        scriptReader.close();
    }

    private ArrayList<Hotel> readHotels(ResultSet rs) throws Exception {
        ArrayList<Hotel> res = new ArrayList<Hotel>();
        while (rs.next()) {
            res.add(new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("town"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant"))));
        }
        rs.close();
        closeConnection();
        return res;
    }

    private ArrayList<Reservation> readReservations(ResultSet rs) throws Exception {
        ArrayList<Reservation> res = new ArrayList<Reservation>();
        while (rs.next()) {
            res.add(new Reservation(rs.getString("reservationId"),rs.getString("created"),rs.getString("startDate"),rs.getString("endDate"),
            rs.getString("cName"),rs.getString("cEmail"),rs.getString("cPhone"),rs.getInt("numCustomers"),rs.getInt("hotelId"),rs.getInt("roomNum")));
        }
        rs.close();
        closeConnection();
        return res;
    }

    private ArrayList<Room> readRooms(ResultSet rs) throws Exception {
        ArrayList<Room> res = new ArrayList<Room>();
        while (rs.next()) {
            res.add(new Room(rs.getInt("roomNum"),rs.getInt("hotelId"),rs.getInt("price"),rs.getInt("type"),rs.getInt("numBeds"),rs.getInt("capacity")));
        }
        rs.close();
        closeConnection();
        return res;
    }



    // SQL köll
    // Hotels
    public ArrayList<Hotel> getAllHotels() throws Exception {
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HOTELS");
        return readHotels(rs);
    }
    public Hotel getHotelById(Integer id) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Hotel res = new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("town"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant")));
        rs.close();
        closeConnection();
        return res;
    }
    public Hotel getHotelByName(String name) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE name = ?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        Hotel res = new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("town"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant")));
        rs.close();
        closeConnection();
        return res;
    }

    public ArrayList<Hotel> getHotelsByStarRating(Integer starRating) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE starRating = ?");
        pstmt.setInt(1, starRating);
        ResultSet rs = pstmt.executeQuery();
        return readHotels(rs);
    }

    public ArrayList<Hotel> getHotelsInArea(Integer areaCode) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE region = ?");
        pstmt.setInt(1, areaCode);
        ResultSet rs = pstmt.executeQuery();
        return readHotels(rs);
    }

    public ArrayList<Hotel> getHotelsInTown(String townName) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE town = ?");
        pstmt.setString(1, townName);
        ResultSet rs = pstmt.executeQuery();
        return readHotels(rs);
    }

    // public ArrayList<Hotel> getHotelsFromFilter(Map<String, String> filters) throws Exception {
    //     getConnection();
    //     String query = "SELECT * FROM HOTELS WHERE ";
    //     for (Map.Entry<String, String> entry : filters.entrySet()) {
    //         query += entry.getKey() + " = '" + entry.getValue() + "' AND ";
    //     }
    //     query = query.substring(0, query.length() - 5);
    //     Statement stmt = conn.createStatement();
    //     ResultSet rs = stmt.executeQuery(query);
    //     return readHotels(rs);
    // }


    public void createHotel(Hotel hotel) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO HOTELS VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        pstmt.setInt(1,hotel.getId());
        pstmt.setString(2,hotel.getName());
        pstmt.setInt(3,hotel.getRegion());
        pstmt.setString(4,hotel.getTown());
        pstmt.setString(5,hotel.getImage());
        Info info = hotel.getHotelInfo();
        pstmt.setInt(6,info.getStarRating());
        pstmt.setInt(7,info.getPriceRating());
        pstmt.setBoolean(8,info.getGym());
        pstmt.setBoolean(9,info.getSpa());
        pstmt.setBoolean(10,info.getWifi());
        pstmt.setBoolean(11,info.getBar());
        pstmt.setBoolean(12,info.getRestaurant());
        pstmt.executeUpdate();
        closeConnection();
    }



    public ArrayList<Reservation> getReservationsByhotelId(Integer hotelId) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "SELECT reservationId, created, startDate, endDate, cName, cEmail, cPhone, numCustomers FROM RESERVATIONS WHERE hotelId = ?");
        pstmt.setInt(1, hotelId);
        ResultSet rs = pstmt.executeQuery();
        return readReservations(rs);
    }

    public void logReservation(Reservation resv) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO RESERVATIONS(?,?,?,?,?,?,?,?,?,?)");
        pstmt.setString(1,resv.getReservationId());
        pstmt.setString(2,resv.getCreated());
        pstmt.setString(3,resv.getStartDate());
        pstmt.setString(4,resv.getEndDate());
        pstmt.setString(5,resv.getCustomerName());
        pstmt.setString(6,resv.getCustomerEmail());
        pstmt.setString(7,resv.getCustomerPhone());
        pstmt.setInt(8,resv.getNumCustomers());
        pstmt.setInt(9,resv.getHotelId());
        pstmt.setInt(10,resv.getRoomNum());
        pstmt.executeUpdate();
        closeConnection();
    }

    public void removeReservation(String resID) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "DELETE FROM RESERVATIONS WHERE reservationId = ?");
        pstmt.setString(1, resID);
        pstmt.executeUpdate();
        closeConnection();
    }

    // Rooms
    public Integer getPrice(Integer hotelId, Integer roomNum) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT price FROM ROOMS WHERE hotelId = ? and roomNum = ?");
        pstmt.setInt(1, hotelId); 
        pstmt.setInt(2, roomNum);
        ResultSet rs = pstmt.executeQuery();
        Integer res = rs.getInt("price");
        rs.close();
        closeConnection();
        return res;
    }

    public ArrayList<Room> sortAllRoomsByPrice() throws Exception {
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ROOMS ORDER BY price DESC");
        return readRooms(rs);
    }

    public Room getRoomByIds(Integer hotelId, Integer roomNum) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ROOMS WHERE hotelId = ? and roomNum = ?");
        pstmt.setInt(1, hotelId); 
        pstmt.setInt(2, roomNum);
        ResultSet rs = pstmt.executeQuery();
        Room res = new Room(rs.getInt("roomNum"),rs.getInt("hotelId"),rs.getInt("price"),rs.getInt("type"),rs.getInt("numBeds"),rs.getInt("capacity"));
        rs.close();
        closeConnection();
        return res;
    }

    public ArrayList<Room> getRoomsByHotelId(Integer hotelId) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ROOMS WHERE hotelId = ?");
        pstmt.setInt(1, hotelId); 
        ResultSet rs = pstmt.executeQuery();
        return readRooms(rs);
    }

    public ArrayList<Room> sortAllRoomsByStars() throws Exception {
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HOTELS JOIN ROOMS WHERE id = hotelId ORDER BY starRating DESC");
        return readRooms(rs);
    }
  
    public ArrayList<Reservation> getAllReservations() throws Exception{
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVATIONS");
        return readReservations(rs);
    }

    public ArrayList<Reservation> getRoomReservations(Integer hotelID, Integer roomNum) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "SELECT * FROM RESERVATIONS WHERE (hotelId = ? AND roomNum = ?)"
        );
        pstmt.setInt(1, hotelID);
        pstmt.setInt(2, roomNum);
        ResultSet rs = pstmt.executeQuery();
        return readReservations(rs);
    }

    // public ArrayList<Hotel> getAvailableHotels(Integer id, Integer maxNum) throws Exception {
    //     getConnection();
    //     PreparedStatement pstmt = conn.prepareStatement(
    //         "select id,name,sum(capacity) from hotels join rooms where hotelId = ? group by ?"
    //     );
    //     pstmt.setInt(1, id);
    //     pstmt.setInt(2, id);
    //     ResultSet rs = pstmt.executeQuery();
    //     ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    //     while (rs.next()) {
    //         Hotel hotel = new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("town"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant")));
    //         Integer sum = rs.getInt("sum(capacity)");
    //         if (sum <= maxNum) {
    //             hotels.add(hotel);
    //         }
    //     }
    //     return hotels;
    // }


    // Get bookings by hotel
    // Get Rooms by hotel
    // Get hotel id by name
    // Get Rooms by hotel name
    // is Room booked?
    // Get room info by roommnr and hotel name/id
    //

}
