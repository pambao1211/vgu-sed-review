import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Booking zumba = new Zumba();
        Booking bad = new Badminton();

        Booking zumbaLocker = new BookingWithLocker(zumba);
        Booking zumbaParking = new BookingWithParking(zumbaLocker);
        Booking zumbaFinal = new BookingWithLocker(zumbaParking);

        Booking badFinal = new BookingWithParking(bad);

        zumbaFinal.pay();

        badFinal.pay();
    }
}