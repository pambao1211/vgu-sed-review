public class Booking {
    String owner;
    String type;
    String center;

    public void display(){
        System.out.printf("[%s,%s,%s]\n", owner, type, center);
    }
}
