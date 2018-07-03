package _001_040._007_reverseInteger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    private ReverseInteger reverseInteger;

    @Before
    public void setUp() throws Exception {
        this.reverseInteger = new ReverseInteger();
    }

    @Test
    public void reverse() {
        assertEquals(21, this.reverseInteger.reverse(120));
        assertEquals(321, this.reverseInteger.reverse(123));
        assertEquals(-321, this.reverseInteger.reverse(-123));
    }
}