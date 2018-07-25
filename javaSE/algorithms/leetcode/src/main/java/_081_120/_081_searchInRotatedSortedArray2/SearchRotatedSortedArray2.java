package _081_120._081_searchInRotatedSortedArray2;

class SearchRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int pivotIndex = this.findPivotIndex(nums, 0, nums.length-1);
        System.out.println(pivotIndex);
        if (pivotIndex == -1) {
            return this.binarySearch(nums, 0, nums.length-1, target);
        }

        if (nums[0] <= target) {
            return this.binarySearch(nums, 0, pivotIndex, target);
        }

        return this.binarySearch(nums, pivotIndex+1, nums.length-1, target);
    }

    private int findPivotIndex(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (mid < end && nums[mid] > nums[mid+1]) {
            return mid;
        }

        if (mid > start && nums[mid] < nums[mid-1]) {
            return mid-1;
        }

        if (nums[start] < nums[mid]) {
            return this.findPivotIndex(nums, mid+1, end);
        } else if (nums[start] > nums[mid]) {
            return this.findPivotIndex(nums, start, mid-1);
        } else {
            if (this.findPivotIndex(nums, mid+1, end) == -1) {
                return this.findPivotIndex(nums, start, mid-1);
            }

            return this.findPivotIndex(nums, mid+1, end);
        }

    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end)/2;

        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return this.binarySearch(nums, mid+1, end, target);
        } else {
            return this.binarySearch(nums, start, mid-1, target);
        }
    }
}
