package _081_120._108_convertSortedArraytoBST;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertSortedArrayToBSTTest {

    private ConvertSortedArrayToBST convertSortedArrayToBST;

    @Before
    public void setUp() throws Exception {
        this.convertSortedArrayToBST = new ConvertSortedArrayToBST();
    }

    @Test
    public void sortedArrayToBST() {
        int[] nums = {-10,-3,0,5,9};

        ConvertSortedArrayToBST.TreeNode root = this.convertSortedArrayToBST.sortedArrayToBST(nums);
    }
}