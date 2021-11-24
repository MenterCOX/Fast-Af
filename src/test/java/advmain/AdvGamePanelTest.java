package advmain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvGamePanelTest {

    @Test
    public void test() {
        AdvGamePanel test = new AdvGamePanel();
        assertEquals(48,test.maxWorldCol);
        assertEquals(25, test.maxWorldRow);
    }
}