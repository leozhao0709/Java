package _001_040.zigzagConversion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigzagConversionTest {

    private ZigzagConversion zigzagConversion;

    @Before
    public void setUp() throws Exception {
        this.zigzagConversion = new ZigzagConversion();
    }

    @Test
    public void convert() {
        assertEquals(this.zigzagConversion.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");

    }
}