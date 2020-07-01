public class NullCourt implements AbstractCourt {
    private static NullCourt nullCourt = null;

    private NullCourt(){}

    public static NullCourt getNullCourt(){
        if(nullCourt == null){
            nullCourt = new NullCourt();
        }
        return nullCourt;
    }

    public void book() {
        System.out.println("There is no court available yet! Please try again later.");
    }
}
