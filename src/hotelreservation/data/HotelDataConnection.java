package hotelreservation.data;

import hotelreservation.entities.Hotel;
import hotelreservation.entities.Room;

import java.sql.*;

public class HotelDataConnection implements DatabaseConnection {

    private static HotelDataConnection instance = null;

	private Connection conn = null;

	private HotelDataConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", ""); // breyta þessu
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}


	/**
	 * Returns the instance of the MockConnection
	 * 
	 * @return the MockConnection instance
	 */
	public static HotelDataConnection getInstance() {
		if (instance == null) {
			instance = new HotelDataConnection();
		}
		return instance;
	}

	private void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}


	@Override
	public Hotel getHotelByID(Integer ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Room getRoomByID(Integer ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
