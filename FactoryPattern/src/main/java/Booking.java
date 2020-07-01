public class Booking {
    private String owner;
    private String type;
    private String id;

    public Booking(String owner, String type, String id) {
        this.owner = owner;
        this.type = type;
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
