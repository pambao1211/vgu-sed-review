public class Zumba implements Booking {
    private static final int price = 30;
    public int pay() {
        System.out.println("You have pay for Zumba: + " + price);
        return price;
    }

    public void cancel() {
        System.out.println("You have been return" + price);
    }
}
