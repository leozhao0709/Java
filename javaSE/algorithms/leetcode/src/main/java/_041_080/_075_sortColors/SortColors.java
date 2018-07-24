package _041_080._075_sortColors;

class SortColors {

    public void sortColors(int[] nums) {
        int lt = 0;
        int gt = nums.length - 1;
        int i = 0;
        while (i <= gt) {
            if (nums[i] == 0) {
                this.swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] == 2) {
                this.swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
