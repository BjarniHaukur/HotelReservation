package hotelreservation.entities;

import hotelreservation.controllers.*;

import org.junit.Test;
import org.junit.Before;

public class HotelTest {
    private Hotel hotel1;
    private HotelControllerMock hotelController;

    @Before
    void setUp() {
        hotel1 = new Hotel("test", 1, 5, 3);
        hotelController = HotelControllerMock.getInstance();
    }

    @Test
    public void testGetId() {
        
    }

    @Test
    public void testGetName(Integer ID) {
        System.out.println(hotelController.getHotelByID(ID).getName());
        //
    }

    @Test
    public void testGetPriceRating(Integer ID) {
        System.out.println(hotelController.getHotelByID(ID).getPriceRating());
    }
}
