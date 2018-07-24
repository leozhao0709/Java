package _041_080._080_removeDuplicatesFromSortedArray2;

class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int flag = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev && (flag == 0 || flag == 1)) {
                count++;
                flag++;
            } else if (nums[i] != prev) {
                flag = 0;
                count++;
                nums[count] = nums[i];
                prev = nums[i];
            }
        }

        return count+1;
    }
}
