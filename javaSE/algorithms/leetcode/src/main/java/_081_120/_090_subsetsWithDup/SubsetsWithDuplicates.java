package _081_120._090_subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        this.getSubsets(nums, 0, nums.length-1, new ArrayList<>(), res);
        return res;
    }

    private void getSubsets(int[] nums, int start, int end, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = start; i <= end; i++) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }

            curr.add(nums[i]);
            this.getSubsets(nums, i+1, end, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
