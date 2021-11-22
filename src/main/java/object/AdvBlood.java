package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AdvBlood extends AdvSuperObject {

    public AdvBlood() {

        name = "Blood";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/bonus.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
