package hotelreservation.data;

public class Room {

    enum Type {
        STANDARD,
        SUITE
    }

    private String id;
    private Type type;
    private int numBeds;
    
    public Room(String id, Type type, int numBeds) {
        this.id = id;
        this.type = type;
        this.numBeds = numBeds;
    }
}
