package _081_120._088_mergeSortedArray;

class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int i = 0, j = 0, k = 0;

        while (j < m || k < n) {
            if (j >= m) {
                while (k < n) {
                    nums1[i++] = nums2[k++];
                }
            } else if (k >= n) {
                while (j < m) {
                    nums1[i++] = temp[j++];
                }
            } else if (temp[j] > nums2[k]) {
                nums1[i++] = nums2[k++];
            } else {
                nums1[i++] = temp[j++];
            }
        }
    }
}
