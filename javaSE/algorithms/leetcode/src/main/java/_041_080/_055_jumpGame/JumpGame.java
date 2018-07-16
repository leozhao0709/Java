package _041_080._055_jumpGame;

class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        boolean[] canJumpTo = new boolean[nums.length];
        canJumpTo[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (canJumpTo[i]) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (j + i >= nums.length-1) {
                        return true;
                    }

                    canJumpTo[j + i] = true;
                }
            }
        }

        return false;
    }
}
