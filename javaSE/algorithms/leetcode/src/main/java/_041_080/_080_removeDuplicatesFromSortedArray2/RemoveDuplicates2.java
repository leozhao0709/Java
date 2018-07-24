package _041_080._080_removeDuplicatesFromSortedArray2;

class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ref = nums[0];
        int count = 1;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ref) {
                nums[count++] = nums[i];
                ref = nums[i];
                flag = 0;
            } else if (flag == 0) {
                nums[count++] = ref;
                flag++;
            } else {
                flag++;
            }
        }

        return count;
    }
}
