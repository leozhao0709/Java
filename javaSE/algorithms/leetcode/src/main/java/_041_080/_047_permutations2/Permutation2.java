package _041_080._047_permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        this.permutation2(nums, 0, nums.length-1, res);
        return res;
    }

    private void permutation2(int[] nums, int start, int end, List<List<Integer>> res) {
        if (start > end) {
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) {
                temp.add(num);
            }

            res.add(temp);
            return;
        }

        for (int i = start; i <= end; i++) {
            if (!this.shouldSwap(nums, i, end)) {
                continue;
            }

            this.swap(nums, i, start);
            this.permutation2(nums, start+1, end, res);
            this.swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private boolean shouldSwap(int[] nums, int start, int end) {
        for (int i = start+1; i <= end ; i++) {
            if (nums[i] == nums[start]) {
                return false;
            }
        }

        return true;
    }
}
