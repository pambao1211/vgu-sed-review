import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Center bd001 = BD001Center.getInstance();
        Center bd002 = BD002Center.getInstance();
        Booking zum1 = bd001.createZumba("Bob");
        Booking zum2 = bd002.createZumba("Alice");
        Booking bad1 = bd001.createBadminton("Jack");
        Booking bad2 = bd002.createBadminton("John");

        zum1.display();
        zum2.display();
        bad1.display();
        bad2.display();
    }
}