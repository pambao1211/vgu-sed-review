public class BookingWithParking extends BookingWithOption {
    private static final int price = 5;
    public BookingWithParking(Booking booking) {
        super(booking);
    }

    public int pay() {
        int totalCost = booking.pay() + price;
        System.out.println("You have added a locker: + " + price + " Total cost is: " + totalCost);
        return totalCost;
    }

    public void cancel() {
        System.out.println("You have canceled parking : - " + price);
        booking.cancel();
    }
}
