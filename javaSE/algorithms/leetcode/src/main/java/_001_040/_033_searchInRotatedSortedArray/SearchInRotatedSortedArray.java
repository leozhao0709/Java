package _001_040._033_searchInRotatedSortedArray;

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int pivot = this.findPivot(nums, 0 , nums.length - 1);

        if (pivot == -1) {
            return this.binarySearch(nums, 0, nums.length-1, target);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (nums[0] <= target) {
            return this.binarySearch(nums, 0, pivot-1, target);
        } else {
            return this.binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    private int findPivot(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end -start) / 2;

        if (mid < end && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        
        if (mid > start && nums[mid] < nums[mid - 1]) {
            return mid-1;
        }
        
        if (nums[start] < nums[mid]) {
            return findPivot(nums, mid+1, end);
        }

        return findPivot(nums, start, mid - 1);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return this.binarySearch(nums, mid + 1, end, target);
        } else {
            return this.binarySearch(nums, start, mid-1, target);
        }
    }
}
