package game;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GameLoopTest {

    @Test
    public void testSetFile() {
        System.out.println("setFile");
        GameLoop instance = new GameLoop();
        instance.loop();
    }
}