package hotelreservation.entities;

import java.util.ArrayList;
import hotelreservation.controllers.HotelController;

public class Info {

    private Integer starRating;
    private Integer priceRating;
    private Boolean gym;
	private Boolean pool;
    private Boolean spa;
    private Boolean wifi;
    private Boolean bar;
    private Boolean restaurant;
	private Boolean breakfast;



    public Info(Integer starRating, Integer priceRating, Boolean gym, Boolean pool, Boolean spa, Boolean wifi, Boolean bar, Boolean restaurant, Boolean breakfast) {

        this.starRating = starRating;
		this.priceRating = priceRating;
        this.gym = gym;
		this.pool = pool;
        this.spa = spa;
        this.wifi = wifi;
        this.bar = bar;
        this.restaurant = restaurant;
		this.breakfast = breakfast;
    }

    // To string
    public String toString() {
        String allInfo = "";
        allInfo += "Star Rating: " + this.starRating + "\n";
        allInfo += "Price Rating: " + this.priceRating + "\n";
        allInfo += this.gym? "gym\n": "";
		allInfo += this.pool? "pool\n": "";
        allInfo += this.spa? "spa\n": "";
        allInfo += this.wifi? "wifi\n": "";
        allInfo += this.bar? "bar\n": "";
        allInfo += this.restaurant? "restaurant\n": "";
		allInfo += this.breakfast? "breakfast\n": "";
        if (allInfo.equals("")) {
            allInfo = "No info";
        }
        return allInfo;
    }

    public Integer getStarRating() {
		return this.starRating;
	}

	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}

	public Integer getPriceRating() {
		return this.priceRating;
	}

	public void setPriceRating(Integer priceRating) {
		this.priceRating = priceRating;
	}

	public Boolean getGym() {
		return this.gym;
	}

	public void setGym(Boolean gym) {
		this.gym = gym;
	}

	public Boolean getSpa() {
		return this.spa;
	}

	public void setSpa(Boolean spa) {
		this.spa = spa;
	}

	public Boolean getWifi() {
		return this.wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getBar() {
		return this.bar;
	}

	public void setBar(Boolean bar) {
		this.bar = bar;
	}

	public Boolean getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Boolean restaurant) {
		this.restaurant = restaurant;
	}

	public Boolean getBreakfast() {
		return this.breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}
}
