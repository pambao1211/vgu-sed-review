import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Client {
    @Test
    public void client(){
        Court court1 = new Court("court1", false);
        Court court2 = court1.addCourt("court2", true);
        Court court3 = court1.addCourt("court3", true);

        court3.book();
        court3.book();
        court3.book();
    }
}