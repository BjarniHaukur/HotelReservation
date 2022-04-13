package hotelreservation.entities;

import java.util.ArrayList;

public class Room {

    private Integer roomNum;
    private Integer price;
    private Integer numBeds;
    private Integer capacity;
    private Boolean breakfast;

    public Room(Integer roomNum, Integer price, Integer numBeds, Integer capacity, Boolean breakfast) {
        this.roomNum = roomNum;
        this.price = price;
        this.numBeds = numBeds;
        this.capacity = capacity;
        this.breakfast = breakfast;
    }

    public String toString() {
        String allInfo = "";
        allInfo += "Room Number: " + this.roomNum + "\n";
        allInfo += "price: " + this.price + "\n";
        allInfo += "Number of beds: " + this.numBeds + "\n";
        allInfo += "Capacity: " + this.capacity + "\n";
        allInfo += "Breakfast: " + this.breakfast + "\n";
        return allInfo;
    }

	public Integer getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumBeds() {
		return this.numBeds;
	}

	public void setNumBeds(Integer numBeds) {
		this.numBeds = numBeds;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getBreakfast() {
		return this.breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}


    /**
     * Checks whether the room is available for the given date range.
     * @params: Long dateFrom, Long dateTo
     * @return: boolean, true if the room is available then, false if not
     */
    // public Boolean isAvailable(Long dateFrom, Long dateTo) {
    //     for (Reservation reservation : reservations) {
            
    //     }
    // }

}
