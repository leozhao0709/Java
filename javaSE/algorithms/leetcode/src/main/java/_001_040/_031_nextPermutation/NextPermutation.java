package _001_040._031_nextPermutation;

class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        int j = nums.length-1;

        while (j >= 0 && i>= 0 && nums[j] <= nums[i]) {
            j--;
        }
        System.out.println(i + " " + j);
        if (i >= 0 && j >= 0) {
            this.swap(i, j, nums);
        }
        this.reverse(i+1, nums.length-1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int i, int j, int[] nums) {
        while (i <= j) {
            this.swap(i, j, nums);
            i++;
            j--;
        }
    }
}
