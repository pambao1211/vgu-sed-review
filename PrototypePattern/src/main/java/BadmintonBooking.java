public class BadmintonBooking extends Booking {
    private String court;
    public BadmintonBooking(String owner, String court) {
        super(owner, "Badminton");
        this.court = court;
    }

    public void display() {
        System.out.println(
                "["
                        + type
                        + ","
                        + owner
                        + ","
                        + court
                        + "]"
        );
    }

    private BadmintonBooking(BadmintonBooking badmintonBooking){
        super(badmintonBooking.owner, badmintonBooking.type);
        this.court = badmintonBooking.court;

    }
    public Clonable cloneA() {
        return new BadmintonBooking(this);
    }
}
