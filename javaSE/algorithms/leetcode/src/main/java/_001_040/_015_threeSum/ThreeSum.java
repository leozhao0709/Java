package _001_040._015_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            List<List<Integer>> temp = this.twoSum(-nums[i], nums, i+1);
            if (temp.size() > 0) {
                for(List<Integer> list: temp) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int target, int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                res.add(temp);
                i++;
                j--;
                while (i < nums.length && nums[i] == nums[i - 1]) i++;
                while (j >= 0 && nums[j] == nums[j+1]) j--;
            }
        }

        return res;
    }
}
