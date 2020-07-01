public abstract class Observer {
    public abstract void notify(Subject subject);

    public void subscribe(Subject subject){
        subject.add(this);
    }

    public void unSubsribe(Subject subject) {
        subject.delete(this);
    }
}
