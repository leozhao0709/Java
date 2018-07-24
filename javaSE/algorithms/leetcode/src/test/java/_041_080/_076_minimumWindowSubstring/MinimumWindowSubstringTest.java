package _041_080._076_minimumWindowSubstring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {

    private MinimumWindowSubstring minimumWindowSubstring;

    @Before
    public void setUp() throws Exception {
        this.minimumWindowSubstring = new MinimumWindowSubstring();
    }

    @Test
    public void minWindow() {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(this.minimumWindowSubstring.minWindow(s, t));
    }
}