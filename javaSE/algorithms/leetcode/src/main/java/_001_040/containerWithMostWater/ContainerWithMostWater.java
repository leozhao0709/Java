package _001_040.containerWithMostWater;

class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}