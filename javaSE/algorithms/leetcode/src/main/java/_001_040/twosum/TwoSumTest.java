package _001_040.twosum;

import org.junit.Test;

import java.util.Arrays;


public class TwoSumTest {

    @Test
    public void twoSum() {
        TwoSum twoSum = new TwoSum();

        int[] res = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }
}