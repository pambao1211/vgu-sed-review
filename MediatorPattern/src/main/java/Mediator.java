import java.util.ArrayList;
import java.util.HashMap;

public class Mediator {
    private HashMap<Person, ArrayList<Person>> list;

    private static Mediator mediator = null;

    private Mediator(){
        list = new HashMap<Person, ArrayList<Person>>();
    }

    public static Mediator getInstance(){
        if(mediator == null){
            mediator = new Mediator();
        }
        return mediator;
    }

    public void register(Person sender, Person receiver){
        if(sender.getMediator() == null){
            sender.setMediator(this);
        }
        if(receiver.getMediator() == null){
            receiver.setMediator(this);
        }
        list.putIfAbsent(sender, new ArrayList<Person>());
        list.putIfAbsent(receiver, new ArrayList<Person>());
        list.get(sender).add(receiver);
        list.get(receiver).add(sender);
    }

    public void unRegister(Person sender, Person receiver){
        if(list.containsKey(sender))
        list.get(sender).remove(receiver);
        if(list.containsKey(receiver))
        list.get(receiver).remove(sender);
    }

    public void notifyReceivers(Person sender){
        ArrayList<Person> receivers = list.get(sender);
        for(Person receiver : receivers){
            receiver.updateChange(sender.getName(), sender.getStatus());
        }
    }

}
