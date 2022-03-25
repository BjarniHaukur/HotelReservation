package hotelreservation;

import hotelreservation.entities.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class hotelControllerTest {

    private Hotel hotel1;

    // private HotelController hotelController;
    @Before
    public void setUp() {
        hotel1 = new Hotel(1, 2, 3, 4);
        hotelController = HotelController.getInstance();
    }

    @After
    public void tearDown() {
        hotel1 = null;
    }

    @test
    public void testID() {
        assertEquals(1, hotel1.getID());
    }

}