package hotelreservation;

import hotelreservation.entities.*;

import org.junit.Assert;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import hotelreservation.controllers;

import static org.junit.Assert.*;

/**
 * Testing suite for Hotel Controller.
 * 
 */
public class hotelControllerTest {

    private Hotel hotel1;
    private HotelController hotelController;

    @Before
    void setUp() {
        hotel1 = new Hotel("test", 1, 5, 3);
        hotelController = HotelController.getInstance();
    }

    @After
    public void tearDown() {
        hotel1 = null;
    }

    @Test
    void testID() {
        assertEquals(1, hotel1.getID());
    }

}