public class Badminton implements Booking {
    private static final int price = 50;
    public int pay() {
        System.out.println("You have pay for Badminton: + " + price);
        return price;
    }

    public void cancel() {
        System.out.println("You have been return" + price);
    }
}
