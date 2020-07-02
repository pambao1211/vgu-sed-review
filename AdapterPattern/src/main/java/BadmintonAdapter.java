public class BadmintonAdapter extends BookingAdapter {
    private BadmintonBooking badmintonBooking;

    public BadmintonAdapter(BadmintonBooking badmintonBooking) {
        this.badmintonBooking = badmintonBooking;
    }

    @Override
    public void extend(int minutes) {
        badmintonBooking.extend(minutes/60, minutes%60);
    }
}
