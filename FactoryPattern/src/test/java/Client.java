import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client() throws IOException {
        setUp();
        ArrayList<Booking> bookings = Factory.createBookings("Booking.json");
        for(Booking booking : bookings){
            System.out.println(booking.getClass().getSimpleName());
        }
    }
    private void setUp(){
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(new ZumBooking("Alice", "2246"));
        bookings.add(new BadBooking("Bob", "567"));

        try {
            FileWriter fileWriter = new FileWriter("Booking.json");
            Gson gson = new Gson();
            gson.toJson(bookings, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}