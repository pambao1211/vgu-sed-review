public class BD001Center extends Center {
    private static BD001Center bd001Center = null;

    private BD001Center(){}

    public static BD001Center getInstance(){
        if(bd001Center == null){
            bd001Center = new BD001Center();
        }
        return bd001Center;
    }
    private static final String centerName = "BD001";
    public Zumba createZumba(String owner) {
        return new BD001Zumba(owner, centerName);
    }

    public Badminton createBadminton(String owner) {
        return new BD001Badminton(owner, centerName);
    }
}
