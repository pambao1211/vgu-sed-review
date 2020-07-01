public class Court implements AbstractCourt {
    private String name;
    private boolean available;
    private static Court firstCourt;
    private Court nextCourt;

    public void setNextCourt(Court nextCourt) {
        this.nextCourt = nextCourt;
    }

    public Court(String name, boolean available) {
        if(firstCourt == null){
            firstCourt = this;
        }
        this.name = name;
        this.available = available;
    }

    public Court addCourt(String name , boolean available){
        Court court = new Court(name, available);
        court.setNextCourt(this.nextCourt);
        this.setNextCourt(court);
        return court;
    }

    private void privateBook(){
        if(available){
            available = false;
            System.out.println(
                    "You have successfully booked "
                    + name
            );
        } else {
            if(nextCourt != null){
                nextCourt.privateBook();
            } else{
                NullCourt.getNullCourt().book();
            }
        }
    }
    public void book() {
        firstCourt.privateBook();
    }
}
