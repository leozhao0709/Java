package _001_040._012_intToRoman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntToRomanTest {

    private IntToRoman intToRoman;

    @Before
    public void setUp() throws Exception {
        this.intToRoman = new IntToRoman();
    }

    @Test
    public void intToRoman() {
        assertEquals("III", this.intToRoman.intToRoman(3));
    }
}