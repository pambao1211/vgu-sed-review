public class BD002Center extends Center {
    private static BD002Center bd002Center = null;
    private BD002Center(){}

    public static BD002Center getInstance(){
        if(bd002Center == null){
            bd002Center = new BD002Center();
        }
        return bd002Center;
    }
    private static final String centerName = "BD002";
    public Zumba createZumba(String owner) {
        return new BD002Zumba(owner, centerName);
    }

    public Badminton createBadminton(String owner) {
        return new BD002Badminton(owner, centerName);
    }
}
