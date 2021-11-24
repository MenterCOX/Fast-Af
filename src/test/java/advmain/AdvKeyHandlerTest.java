package advmain;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvKeyHandlerTest {

    @Test
    void keyTyped() {
            Assert.assertNotNull(new AdvKeyHandler());
    }

    @Test
    void keyPressed() {Assert.assertNotNull(new AdvKeyHandler());
    }

    @Test
    void keyReleased() {Assert.assertNotNull(new AdvKeyHandler());
    }
}