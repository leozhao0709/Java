package _041_080._046_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        this.permute(nums, 0, nums.length-1, res);
        return res;
    }

    private void permute(int[] nums, int start, int end, List<List<Integer>> res) {
        if (start >= end) {
            List<Integer> temp = new ArrayList<>();

            for(int num: nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for (int i = start; i <= end ; i++) {
            this.swap(nums, start, i);
            this.permute(nums, start+1, end, res);
            this.swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
