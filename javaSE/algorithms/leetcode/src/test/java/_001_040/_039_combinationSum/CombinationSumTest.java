package _001_040._039_combinationSum;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    private CombinationSum combinationSum;

    @Before
    public void setUp() throws Exception {
        this.combinationSum = new CombinationSum();
    }

    @Test
    public void combinationSum() {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> res = this.combinationSum.combinationSum(candidates, target);

        System.out.println(Arrays.deepToString(res.toArray()));
    }
}