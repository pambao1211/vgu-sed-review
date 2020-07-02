public abstract class BookingWithOption implements Booking {
    Booking booking;

    public BookingWithOption(Booking booking) {
        this.booking = booking;
    }

}
