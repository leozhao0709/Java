package _081_120._105_buildTreeFromPreorderAndInorder;

class BuildTreeFromPreorderAndInorder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { this.val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorer, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorer[i]) {
                inIndex = i;
                break;
            }
        }

        root.left = this.helper(preorder, inorer, preStart+1, preEnd, inStart, inIndex-1);
        root.right = this.helper(preorder, inorer, preStart + inIndex - inStart + 1, preEnd, inIndex + 1, inEnd);

        return root;
    }
}
