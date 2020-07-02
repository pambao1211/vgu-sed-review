import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Booking booking = new Booking();
        Payment payment = new Payment();

        FACADE facade = new FACADE(payment);

        facade.cancelRefund();
        facade.bookPay(booking);
        facade.cancelRefund();
    }
}