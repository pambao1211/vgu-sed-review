import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Mediator mediator = Mediator.getInstance();

        Person player1 = new Player("Player1", "free");
        Person player2 = new Player("Player2", "free");
        Person coach1 = new Coach("Coach1", "free");
        Person coach2 = new Coach("Coach2", "free");

        mediator.register(player1,coach1);
        mediator.register(player2, coach1);
        mediator.register(player1, coach2);

        mediator.unRegister(player2, coach2);
        player1.updateStatus("busy");
        coach1.updateStatus("busy");

    }
}