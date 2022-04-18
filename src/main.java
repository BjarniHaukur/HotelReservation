
import java.sql.SQLException;
import hotelreservation.controllers.HotelController;

import java.text.SimpleDateFormat;  
import java.util.Date;
import hotelreservation.entities.*;  

public class main {
    public static void main(String args[]) throws Exception {  
        String sDate1="31/12/1998";  
        String sDate2="31/12/2000";  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(sDate1);
        Date date2 = sdf.parse(sDate2);  
        System.out.println(date1);  
        System.out.println(date2);
        System.out.println(date1.compareTo(date2));
        System.out.println(date2.compareTo(date1));

        if (date1.compareTo(date2) != 0) System.out.println("date1 and date2 dont clash");
        
    }  
}