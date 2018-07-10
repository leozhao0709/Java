package _001_040._040_combinationSum2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSum2Test {

    private CombinationSum2 combinationSum2;

    @Before
    public void setUp() throws Exception {
        this.combinationSum2 = new CombinationSum2();
    }

    @Test
    public void combinationSum2() {
        int[] candidates = {3, 5, 3};
        int target = 8;

        List<List<Integer>> res = this.combinationSum2.combinationSum2(candidates, target);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}