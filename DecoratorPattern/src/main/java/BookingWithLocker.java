public class BookingWithLocker extends BookingWithOption {
    private static final int price = 10;
    public BookingWithLocker(Booking booking) {
        super(booking);
    }

    public int pay() {
        int totalCost = booking.pay() + price;
        System.out.println("You have added a locker: + " + price + " Total cost is: " + totalCost);
        return totalCost;
    }

    public void cancel() {
        System.out.println("You have canceled locker : - " + price);
        booking.cancel();
    }
}
