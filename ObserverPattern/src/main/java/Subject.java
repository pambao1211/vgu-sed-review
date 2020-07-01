import java.util.ArrayList;

public abstract class Subject {
    ArrayList<Observer> observers;
    String state;
    public Subject(){
        observers = new ArrayList<Observer>();
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public void delete(Observer observer){
        observers.remove(observer);
    }

    public void updateState(String state){
        this.state = state;
        notifyAllObserver();
    }

    private void notifyAllObserver(){
        for(Observer observer : observers){
            observer.notify(this);
        }
    }

    public String getState() {
        return state;
    }
}
