public class ZumbaAdapter extends BookingAdapter {
    private ZumbaBooking zumbaBooking;

    public ZumbaAdapter(ZumbaBooking zumbaBooking) {
        this.zumbaBooking = zumbaBooking;
    }

    @Override
    public void extend(int minutes) {
        zumbaBooking.extend(minutes);
    }
}
