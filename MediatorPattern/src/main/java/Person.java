import javax.print.attribute.standard.Media;

public class Person {
    String name;
    String status;
    private Mediator mediator;

    public Person(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void updateStatus(String newStatus){
        status = newStatus;
        mediator.notifyReceivers(this);
    }

    public void updateChange(String name, String status){
        System.out.println(this.name + "'s screen:");
        System.out.println(
                "From "
                + name
                + " new status: "
                + status
        );
    }
}
