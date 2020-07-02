import org.junit.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Booking zumba = new ZumbaBooking();
        zumba.setStartTime(LocalTime.of(14,15));
        zumba.setEndTime(LocalTime.of(16, 00));

        Booking bad = new BadmintonBooking();
        bad.setStartTime(LocalTime.of(17,00));
        bad.setEndTime(LocalTime.of(18,00));

        BookingAdapter zumAdapter = new ZumbaAdapter((ZumbaBooking) zumba);
        BookingAdapter badAdapter = new BadmintonAdapter((BadmintonBooking) bad);

        BookingAdapter[] bookings = {zumAdapter,badAdapter};

        for(BookingAdapter booking : bookings){
            booking.extend(45);
        }
    }

}