package _001_040._033_searchInRotatedSortedArray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray searchInRotatedSortedArray;

    @Before
    public void setUp() throws Exception {
        this.searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    }

    @Test
    public void search() {
        int[] nums = {5, 1, 3};
        int target = 5;

        int res = this.searchInRotatedSortedArray.search(nums, target);

        System.out.println(res);
    }
}