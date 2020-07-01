import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        ZumbaClass zumbaClass = new ZumbaClass();

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        player1.subscribe(zumbaClass);
        player2.subscribe(zumbaClass);

        player2.unSubsribe(zumbaClass);
        zumbaClass.updateState("Opened");
    }
}