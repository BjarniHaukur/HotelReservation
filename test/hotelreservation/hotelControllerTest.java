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

    @Test
    void testFilter() {
        ArrayList<Hotel> hotels = hotelController.getAllHotels();
        String[] info = {"gym","wifi"};
        Integer[] stars = {5};
        ArrayList<Hotel> filteredHotels = hotelController.filterHotels(hotels,stars,info);
        for (Hotel hotel : filteredHotels) {
            assertEquals(true, hotel.getGym());
            assertEquals(true, hotel.getWifi());
            assertEquals(5,hotel.getStarRating());
    }
    @Test
    void testEmptyFilter() {
        ArrayList<Hotel> hotels = hotelController.getAllHotels();
        String[] info = {};
        Integer[] stars = {};
        ArrayList<Hotel> filteredHotels = hotelController.filterHotels(hotels,stars,info);
        Integer countall = 0;
        Integer countfiltered = 0;
        for (Hotel hotel : hotels) {
            countall++;
        }
        for (Hotel hotel : filteredHotels) {
            countfiltered++;
        }
        assertEquals(countall, countfiltered);
    }

}