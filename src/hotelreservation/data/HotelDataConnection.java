package hotelreservation.data;

import hotelreservation.entities.Hotel;
import hotelreservation.entities.Room;
import hotelreservation.entities.Info;

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

    public ArrayList<Hotel> getAllHotels() throws Exception{
        getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HOTELS");
        ArrayList<Hotel> res = new ArrayList<Hotel>();
        while (rs.next()) {
            res.add(new Hotel(rs.getInt("id"),rs.getString("name"), rs.getInt("region"), rs.getString("address"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant"))));
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
        Hotel res = new Hotel(rs.getInt("id"),rs.getString("name"), rs.getInt("region"), rs.getString("address"),rs.getString("image"),new Info(rs.getInt("starRating"),rs.getInt("priceRating"),rs.getBoolean("gym"),rs.getBoolean("spa"),rs.getBoolean("wifi"),rs.getBoolean("bar"),rs.getBoolean("restaurant")));
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
    // setja í reservation object
    public Integer getReservationsByhotelId(Integer hotelId) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RESERVATIONS WHERE hotelId = ?");
        pstmt.setInt(1, hotelId);
        ResultSet rs = pstmt.executeQuery();
        Integer res = rs.getInt("hotelId");
        rs.close();
        closeConnection();
        return res;
    }
    public Integer getpriceByhotelIdandroomNum(Integer hotelId, Integer roomNum) throws Exception{
        getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT price FROM HOTELS WHERE hotelId = ? and roomNum = ?");
        pstmt.setInt(1, hotelId); // Veit ekki hvernig maður gerir 2 gæja hérna
        pstmt.setInt(2, roomNum);
        ResultSet rs = pstmt.executeQuery();
        Integer res = rs.getInt("price");
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
