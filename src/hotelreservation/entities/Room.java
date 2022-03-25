package hotelreservation.entities;


public class Room {

    private Integer ID;
    private Integer type;
    private Integer numBeds;

    public Room(Integer ID, Integer type, Integer numBeds) {
        this.ID = ID;
        this.type = type;
        this.numBeds = numBeds;
    }
}
