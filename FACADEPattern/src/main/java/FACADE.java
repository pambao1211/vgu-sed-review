public class FACADE {
    private Booking booking;
    private Payment payment;

    public FACADE(Payment payment) {
        this.payment = payment;
    }

    public void bookPay(Booking booking){
        if(this.booking != null){
            System.out.println("You have already payed for this booking");
        } else {
            this.booking = booking;
            this.booking.book();
            payment.pay();
        }
    }
    public void cancelRefund(){
        if(booking == null){
            System.out.println("You have not payed for the booking yet");
        } else {
            booking.cancel();
            payment.refund();
        }
    }
}
