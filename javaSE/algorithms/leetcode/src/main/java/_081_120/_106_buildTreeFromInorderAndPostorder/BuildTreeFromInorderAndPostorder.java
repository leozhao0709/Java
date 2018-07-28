package _081_120._106_buildTreeFromInorderAndPostorder;

class BuildTreeFromInorderAndPostorder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return this.helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
                break;
            }
        }

        root.left = this.helper(inorder, postorder, inStart, inIndex-1, postStart, postEnd-(inEnd - inIndex + 1));
        root.right = this.helper(inorder, postorder, inIndex+1, inEnd, postStart+(inIndex - inStart+1), postEnd-1);

        return root;
    }
}
