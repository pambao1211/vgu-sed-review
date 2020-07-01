import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Booking zumbaBooking = new ZumbaBooking("Alice", "B008");
        Booking badBooking = new BadmintonBooking("Pambao", "Court1");

        Booking zumbaCloned = (Booking) zumbaBooking.cloneA();
        zumbaCloned.setOwner("Bob");
        zumbaCloned.display();

        Booking badmintonCloned = (Booking) badBooking.cloneA();
        badmintonCloned.setOwner("Jack");
        badmintonCloned.display();
    }
}