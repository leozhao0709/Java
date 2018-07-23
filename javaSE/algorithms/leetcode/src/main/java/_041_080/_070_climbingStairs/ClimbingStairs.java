package _041_080._070_climbingStairs;

class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] steps = new int[n+1];
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }

        return steps[n];
    }
}
