package hotelreservation.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import hotelreservation.data.HotelDataConnection;
import hotelreservation.entities.Hotel;
import hotelreservation.entities.Room;

public class HotelController {
    
    private static HotelController instance = null;
    private HotelDataConnection connection = HotelDataConnection.getInstance();

    /**
     * Returns the instance of the HotelController
     * @return the HotelController instance
     */
    public static HotelController getInstance() {
        if (instance == null) {
            instance = new HotelController();
        }
        return instance;
    }

    public ArrayList<Hotel> getAllHotels() throws Exception {
        return connection.getAllHotels();
    }

    /**
     * @param location: the location in which we want to search for hotels
     * @param numCustomers: the number of customers that we want to accomodate, i.e. the
     * minimum amount of accommodation we need to have
     * @param startDate: the start date of the interval in which we want to search for hotels
     * @param endDate: the end date of the interval in which we want to search for hotels
     * @return an ArrayList of Hotels which fit these criteria
     */
    public ArrayList<Hotel> getAllAvailableHotels(Integer location, Integer numCustomers, LocalDate from, LocalDate to) throws Exception {
        ReservationController reservController = ReservationController.getInstance();
        String fromString = from.toString();
        String toString = to.toString();
        ArrayList<Hotel> hotels = connection.getHotelsInArea(location);
        ArrayList<Hotel> availableHotels = new ArrayList<Hotel>();
        for (Hotel hotel : hotels) {
            ArrayList<Room> rooms = connection.getRoomsByHotelId(hotel.getId());
            Integer count = 0;
            for (Room room : rooms) {
                if (reservController.isAvailable(room.getHotelId(), room.getRoomNum(), fromString, toString)) {
                    count += room.getCapacity();
                }
            }
            if (count >= numCustomers) {
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }

    /**
     * @param hotels: the ArrayList of Hotels we are filtering
     * @param consts: an array of Strings which correspond to boolean criteria for filtering
     * @return the ArrayList of Hotels after filtering
     */
    public ArrayList<Hotel> filterByInfo(ArrayList<Hotel> hotels, String[] constrs) throws Exception {
        ArrayList<Hotel> availableHotels = new ArrayList<Hotel>();
        for (Hotel hotel : hotels) {
            Boolean check = true;
            for (String s: constrs) {
                if(s.contains("gym") && !hotel.getHotelInfo().getGym()){
                    check = false;
                }
                if(s.contains("wifi") && !hotel.getHotelInfo().getWifi()){
                    check = false;
                }
                if(s.contains("breakfast") && !hotel.getHotelInfo().getRestaurant()){
                    check = false;
                }
            }
            if(check){
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }

    public Hotel getHotelByID(Integer ID) throws Exception {
        return connection.getHotelById(ID);
    }

    // getHotelIdByName
    public Hotel getHotelIdByName(String name) throws Exception {
        return connection.getHotelByName(name);
    }

    // getHotelsByStarRating
    // public ArrayList<Hotel> getHotelsByStarRating(Integer starRatings) throws Exception {
    //     return connection.getHotelsByStarRating(starRating);
    // }

}

