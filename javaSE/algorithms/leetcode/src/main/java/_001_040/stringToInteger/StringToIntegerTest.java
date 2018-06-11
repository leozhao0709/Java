package _001_040.stringToInteger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntegerTest {

    private StringToInteger myAtoi;

    @Before
    public void setUp() throws Exception {
        this.myAtoi = new StringToInteger();
    }

    @Test
    public void myAtoi() {
        assertEquals(42, myAtoi.myAtoi("42"));
        assertEquals(-42, myAtoi.myAtoi("-42"));
        assertEquals(4193, myAtoi.myAtoi("4193 with words"));
        assertEquals(0, myAtoi.myAtoi("words and 987"));
        assertEquals(-2147483648, myAtoi.myAtoi("-91283472332"));
        assertEquals(2147483647, myAtoi.myAtoi("9223372036854775808"));
        assertEquals(1, myAtoi.myAtoi("+1"));
        assertEquals(12345678, myAtoi.myAtoi("  0000000000012345678"));
        assertEquals(2147483647, myAtoi.myAtoi("    +11191657170"));
    }
}