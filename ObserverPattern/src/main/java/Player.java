public class Player extends Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void notify(Subject subject) {
        System.out.println(name + "'s screen");
        System.out.println("New state: " + subject.getState());
    }
}
