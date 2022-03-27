package hotelreservation;

import hotelreservation.entities.*;

import hotelreservation.controllers;

import lib.org.junit.After;
import lib.org.junit.Before;
import lib.org.junit.Test;

import static org.junit.Assert.*;

public class hotelControllerTest {

    private Hotel hotel1;
    private HotelController hotelController;

    @Before
    public void setUp() {
        hotel1 = new Hotel("test", 1, 5, 3);
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