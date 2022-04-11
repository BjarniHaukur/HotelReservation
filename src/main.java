
import java.sql.SQLException;
import hotelreservation.controllers.HotelController;



public class main {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        HotelController controller = HotelController.getInstance();
        try {
            System.out.println(controller.getHotelByID(1));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}