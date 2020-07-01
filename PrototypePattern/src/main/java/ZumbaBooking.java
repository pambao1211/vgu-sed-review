public class ZumbaBooking extends Booking {
    private String classRoom;
    public ZumbaBooking(String owner, String classRoom) {
        super(owner, "Zumba");
        this.classRoom = classRoom;
    }

    public void display() {
            System.out.println(
                    "["
                            + type
                            + ","
                            + owner
                            + ","
                            +classRoom
                            + "]"
            );
    }

    private ZumbaBooking(ZumbaBooking zumbaBooking){
        super(zumbaBooking.owner, zumbaBooking.type);
        this.classRoom = zumbaBooking.classRoom;
    }
    public Clonable cloneA() {
        return new ZumbaBooking(this);
    }
}
