package hotelreservation.entities;

public class Room {

    private Integer id;
    private Integer type;
    private Integer numBeds;

    public Room(Integer id, Integer type, Integer numBeds) {
        this.id = id;
        this.type = type;
        this.numBeds = numBeds;
    }
}
