package hotelreservation.entities;

import hotelreservation.controllers.*;

import org.junit.Test;
import org.junit.Before;

public class HotelTest {
    private Hotel hotel1;
    private HotelController hotelController;

    @Before
    void setUp() {
        hotel1 = new Hotel("test", 1, 5, 3);
        hotelController = HotelController.getInstance();
    }

    @Test
    public void testGetId() {

    }

    @Test
    public void testGetName() {

    }

    @Test
    public void testGetPriceRating() {

    }
}
