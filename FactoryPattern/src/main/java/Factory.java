import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static Gson gson = new Gson();

    public static ArrayList<Booking> createBookings(String jsonFile){
        ArrayList<Booking> bookings = null;
        try {
            FileReader fileReader = new FileReader(jsonFile);
            bookings = gson.fromJson(fileReader, new TypeToken<List<Booking>>() {}.getType());
            bookings = downCastBooking(bookings);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    private static ArrayList<Booking> downCastBooking(ArrayList<Booking> bookings){
        for(Booking booking : bookings){
            if(booking.getType().equals("Zumba")){
                ZumBooking newBooking = gson.fromJson(gson.toJson(booking), ZumBooking.class);
                bookings.set(bookings.indexOf(booking), newBooking);
            } else if(booking.getType().equals("Badminton")){
                BadBooking newBooking = gson.fromJson(gson.toJson(booking), BadBooking.class);
                bookings.set(bookings.indexOf(booking), newBooking);
            }
        }
        return bookings;
    }
}
