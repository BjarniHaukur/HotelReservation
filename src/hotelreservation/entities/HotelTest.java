package hotelreservation.entities;

import hotelreservation.controllers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;


public class HotelTest {
    private HotelControllerMock hotelController;

    @Before
    void setUp() {
        hotelController = HotelControllerMock.getInstance();
    }

    // Þarf þetta?
    // @Test
    // public void testGetId() {
    //     assertEquals("Rangá", hotelController.getHotelByID(1).getName());
    //     assertEquals("Hilton", hotelController.getHotelByID(2).getName());
    //     assertEquals("Ölfus", hotelController.getHotelByID(3).getName());
    // }

    @Test
    public void testGetName() {
        assertEquals("Rangá", hotelController.getHotelByID(1).getName());
        assertEquals("Hilton", hotelController.getHotelByID(2).getName());
        assertEquals("Ölfus", hotelController.getHotelByID(3).getName());
    }

    @Test
    public void testGetPriceRating(Integer ID) {
        assertEquals(3, hotelController.getHotelByID(1).getPriceRating());
        assertEquals(4, hotelController.getHotelByID(2).getPriceRating());
        assertEquals(5, hotelController.getHotelByID(3).getPriceRating());
    }

    @After
    public void tearDown(){
        hotelController = null;
    }
}