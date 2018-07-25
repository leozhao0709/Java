package _081_120._081_searchInRotatedSortedArray2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchRotatedSortedArray2Test {

    private SearchRotatedSortedArray2 searchRotatedSortedArray2;

    @Before
    public void setUp() throws Exception {
        this.searchRotatedSortedArray2 = new SearchRotatedSortedArray2();
    }

    @Test
    public void search() {
        int[] nums = {1, 1, 2, 1, 1, 1, 1, 1, 1, 1};
        int target = 2;

        System.out.println(this.searchRotatedSortedArray2.search(nums, target));
    }
}