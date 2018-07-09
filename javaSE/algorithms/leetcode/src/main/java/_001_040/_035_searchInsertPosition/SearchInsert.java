package _001_040._035_searchInsertPosition;

class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return this.binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return this.binarySearch(nums, mid+1, end, target);
        } else {
            return this.binarySearch(nums, start, end-1, target);
        }
    }
}
