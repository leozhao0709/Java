package _001_040._038_countAndSay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayTest {

    private CountAndSay countAndSay;

    @Before
    public void setUp() throws Exception {

        this.countAndSay = new CountAndSay();
    }

    @Test
    public void countAndSay() {
        int n = 5;
        System.out.println(this.countAndSay.countAndSay(n));
    }
}