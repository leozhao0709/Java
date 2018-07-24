package _041_080._078_subsets;

import java.util.ArrayList;
import java.util.List;

class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        this.getSubsets(nums, 0, nums.length-1, new ArrayList<>(), res);

        return res;
    }

    private void getSubsets(int[] nums, int start, int end, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i <= end ; i++) {
            temp.add(nums[i]);
            this.getSubsets(nums, i+1, end, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
