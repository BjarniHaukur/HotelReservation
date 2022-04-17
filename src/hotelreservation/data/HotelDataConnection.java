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
        String dbName = "/HotelData.db";

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

    // SQL köll
    // Hotels
    //TODO spa should be pool
    public ArrayList<Hotel> getAllHotels() throws Exception{
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HOTELS");
        ArrayList<Hotel> res = new ArrayList<Hotel>();
        while (rs.next()) {
            res.add(new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("address"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant"))));
        }
        rs.close();
        closeConnection();
        return res;
    }
    public Hotel getHotelById(Integer id) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOTELS WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Hotel res = new Hotel(rs.getInt("id"),rs.getString("name"),rs.getInt("region"),rs.getString("address"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant")));
        rs.close();
        closeConnection();
        return res;
    }
    public Integer getHotelIdByName(String name) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM HOTELS WHERE name = ?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        Integer res = rs.getInt("id");
        rs.close();
        closeConnection();
        return res;
    }

    public ArrayList<Integer> getHotelIdByStarRating(Integer starRating) throws Exception {
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM HOTELS WHERE starRating = ?");
        pstmt.setInt(1, starRating);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (rs.next()) {
            res.add(rs.getInt("id"));
        }
        rs.close();
        closeConnection();
        return res;
    }

    // public Hotel updateHotel(Integer id, String key, String/Integer value) throws Exception{
    //    
    // }

    public void createHotel(Hotel hotel) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO HOTELS VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, hotel.getId());
        pstmt.setString(2,hotel.getName());
        pstmt.setInt(3,hotel.getRegion());
        pstmt.setString(4,hotel.getAddress());
        pstmt.setString(5,hotel.getImage());
        pstmt.setInt(6,hotel.getHotelInfo().getStarRating());
        pstmt.setInt(7,hotel.getHotelInfo().getPriceRating());
        pstmt.setBoolean(8,hotel.getHotelInfo().getGym());
        pstmt.setBoolean(9,hotel.getHotelInfo().getSpa());
        pstmt.setBoolean(10,hotel.getHotelInfo().getWifi());
        pstmt.setBoolean(11,hotel.getHotelInfo().getBar());
        pstmt.setBoolean(12,hotel.getHotelInfo().getRestaurant());
        pstmt.executeUpdate();
        closeConnection();
    }



    // Reservations
    public ArrayList<Reservation> getReservationsByhotelId(Integer hotelId) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "SELECT reservationId, created, startDate, endDate, cName, cEmail, cPhone, numCustomers FROM RESERVATIONS WHERE hotelId = ?");
        pstmt.setInt(1, hotelId);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Reservation> res = new ArrayList<Reservation>();
        while (rs.next()) {
            res.add(new Reservation(rs.getInt("reservationId"),rs.getString("created"),rs.getString("startDate"),rs.getString("endDate"),
            rs.getString("cName"),rs.getString("cEmail"),rs.getString("cPhone"),rs.getInt("numCustomers")));
        }
        rs.close();
        closeConnection();
        return res;
    }

    public void createReservation(Integer hotelId, Integer roomNum, Reservation resv) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO RESERVATIONS(?,?,?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, resv.getReservationId());
        pstmt.setString(2,resv.getCreated());
        pstmt.setString(3,resv.getStartDate());
        pstmt.setString(4,resv.getEndDate());
        pstmt.setString(5,resv.getCustomerName());
        pstmt.setString(6,resv.getCustomerEmail());
        pstmt.setString(7,resv.getCustomerPhone());
        pstmt.setInt(8,resv.getnumCustomers());
        pstmt.setInt(9,hotelId);
        pstmt.setInt(10,roomNum);
        pstmt.executeUpdate();
        closeConnection();
        return res;
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
        ArrayList<Room> res = new ArrayList<Room>();
        while (rs.next()) {
            res.add(new Room(rs.getInt("roomNum"),rs.getInt("hotelId"),rs.getInt("price"),rs.getInt("type"),rs.getInt("numBeds"),rs.getInt("capacity"),rs.getBoolean("breakfast")));
        }
        rs.close();
        closeConnection();
        return res;
    }

    public ArrayList<Room> sortAllRoomsByStars() throws Exception {
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HOTELS JOIN ROOMS WHERE id = hotelId ORDER BY starRating DESC");
        ArrayList<Room> res = new ArrayList<Room>();
        while (rs.next()) {
            res.add(new Room(rs.getInt("roomNum"),rs.getInt("hotelId"),rs.getInt("price"),rs.getInt("type"),rs.getInt("numBeds"),rs.getInt("capacity"),rs.getBoolean("breakfast")));
        }
        rs.close();
        closeConnection();
        return res;
    }

    // Get bookings by hotel
    // Get Rooms by hotel
    // Get hotel id by name
    // Get Rooms by hotel name
    // is Room booked?
    // Get room info by roommnr and hotel name/id
    //

}
