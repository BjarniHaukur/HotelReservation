package hotelreservation.entities;

import java.util.ArrayList;

public class Hotel {

    private Integer id;
    private String name;
    private Integer region;
    private String address;
    private String image; 
    private Info hotelInfo;
    private ArrayList<Room> rooms;

    public Hotel(Integer id, String name, Integer region, String address, String image, Info hotelInfo) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.address = address;
        this.image = image;
        this.rooms = null;
        this.hotelInfo = hotelInfo;
    }
	// TODO bæta við info í string aðferð
	public String toString() {
        String allInfo = "";
        allInfo += "id: " + this.id + "\n";
        allInfo += "name: " + this.name + "\n";
        allInfo += "region: " + this.region + "\n";
        allInfo += "address: " + this.address + "\n";
        allInfo += "image: " + this.image + "\n";
        return allInfo;
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }

    public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegion() {
		return this.region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Info getHotelInfo() {
		return this.hotelInfo;
	}

	public void setHotelInfo(Info hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public ArrayList<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
}
