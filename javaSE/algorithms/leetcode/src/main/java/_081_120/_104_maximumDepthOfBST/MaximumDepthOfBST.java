package _081_120._104_maximumDepthOfBST;

class MaximumDepthOfBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }
}
