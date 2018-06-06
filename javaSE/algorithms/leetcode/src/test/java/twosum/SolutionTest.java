package twosum;

import org.junit.Test;

import java.util.Arrays;


public class SolutionTest {

    @Test
    public void twoSum() {
        Solution solution = new Solution();

        int[] res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }
}