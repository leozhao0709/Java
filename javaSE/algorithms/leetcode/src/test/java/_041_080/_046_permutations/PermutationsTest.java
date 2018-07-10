package _041_080._046_permutations;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    private Permutations permutations;

    @Before
    public void setUp() throws Exception {
        this.permutations = new Permutations();
    }

    @Test
    public void permute() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> res = this.permutations.permute(nums);

        System.out.println(Arrays.deepToString(res.toArray()));
    }
}