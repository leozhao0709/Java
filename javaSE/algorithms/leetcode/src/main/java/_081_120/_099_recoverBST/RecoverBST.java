package _081_120._099_recoverBST;

class RecoverBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    // 1, 2, 3, 7, 5, 6, 4, 8, 9
    // 3, 2, 1
    // 1, 3, 2, 4

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode middle = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        this.inorderFindReoverNode(root);

        int temp = first.val;
        if (second != null) {
            first.val = second.val;
            second.val = temp;
        } else {
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorderFindReoverNode(TreeNode root) {
        if (root == null || second != null) {
            return;
        }

        this.inorderFindReoverNode(root.left);
        if (prev != null && root.val < prev.val) {
            if (this.first == null) {
                this.first = prev;
                this.middle = root;
            } else {
                this.second = root;
            }
        }

        this.prev = root;
        this.inorderFindReoverNode(root.right);
    }

}
