public abstract class Booking implements Clonable{
    String owner;
    String type;

    public Booking(String owner, String type) {
        this.owner = owner;
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public abstract void display();

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
