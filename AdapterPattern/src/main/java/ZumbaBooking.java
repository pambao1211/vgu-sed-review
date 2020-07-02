public class ZumbaBooking extends Booking {
    public void extend(int minutes){
        super.setStartTime(super.getStartTime().plusMinutes(minutes));
        super.setEndTime(super.getEndTime().plusMinutes(minutes));
        System.out.printf("Your booking have been extended %d minutes\n", minutes);
        System.out.println(
                "New start time: "
                + super.getStartTime().toString()
                + ", New end time: "
                +super.getEndTime().toString()
        );

    }
}
