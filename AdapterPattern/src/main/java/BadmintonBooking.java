public class BadmintonBooking extends Booking {
    public void extend (int hour, int mintues){
        super.setStartTime(super.getStartTime().plusHours(hour).plusMinutes(mintues));
        super.setEndTime(super.getEndTime().plusHours(hour).plusMinutes(mintues));
        System.out.printf("Your booking have been extended %d hour %d minutes\n", hour, mintues);
        System.out.println(
                "New start time: "
                        + super.getStartTime().toString()
                        + ", New end time: "
                        +super.getEndTime().toString()
        );
    }
}
