package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AdvDoor extends AdvSuperObject{

    public AdvDoor() {

        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/door.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
