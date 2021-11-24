package sngame;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ssnakeTest {
    @Test
    public void testSetFile() {
        Assert.assertNotNull(new ssnake(1,2,3,4));
    }

}