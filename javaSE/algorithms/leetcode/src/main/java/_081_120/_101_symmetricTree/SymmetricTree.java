package _081_120._101_symmetricTree;

class SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return this.isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftTreeRoot, TreeNode rightTreeRoot) {
        if (leftTreeRoot == null && rightTreeRoot == null) {
            return true;
        } else if (leftTreeRoot != null && rightTreeRoot != null) {
            if (leftTreeRoot.val != rightTreeRoot.val) {
                return false;
            }

            return this.isSymmetric(leftTreeRoot.left, rightTreeRoot.right) && this.isSymmetric(leftTreeRoot.right, rightTreeRoot.left);
        }

        return false;
    }
}
