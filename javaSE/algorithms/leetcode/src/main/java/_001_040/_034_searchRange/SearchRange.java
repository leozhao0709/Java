package _001_040._034_searchRange;

class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int i = this.binarySearch(nums, 0, nums.length-1, target);

        if (i == -1) {
            return new int[]{-1, -1};
        }

        int j = i, k = i;

        while (j < nums.length - 1 && nums[j] == nums[j+1]) {
            j++;
        }

        while (k > 0 && nums[k] == nums[k-1]) {
            k--;
        }

        return new int[]{k, j};
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            return this.binarySearch(nums, mid+1, end, target);
        } else {
            return this.binarySearch(nums, start, mid-1, target);
        }
    }
}
