package _041_080._047_permutations2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Permutation2Test {

    private Permutation2 permutation2;

    @Before
    public void setUp() throws Exception {
        this.permutation2 = new Permutation2();
    }

    @Test
    public void permuteUnique() {
        int[] nums = {0,0, 1, 9};
        List<List<Integer>> res = this.permutation2.permuteUnique(nums);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}