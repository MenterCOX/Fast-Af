package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AdvExit extends AdvSuperObject{

    public AdvExit() {

        name = "Exit";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/exit.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
