package _081_120._096_uniqueBinarySearchTree;

class UniqueBinarySearchTree {

    public int numTrees(int n) {
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 1; root < i; root++) {
                count[i] += count[root-1] * count[i - root];
            }
        }

        return count[n];
    }
}
