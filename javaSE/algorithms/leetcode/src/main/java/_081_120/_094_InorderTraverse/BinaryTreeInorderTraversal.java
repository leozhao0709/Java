package _081_120._094_InorderTraverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            TreeNode rightNode = node.right;
            if (rightNode != null) {
                stack.push(rightNode);
                while (rightNode.left != null) {
                    stack.push(rightNode.left);
                    rightNode = rightNode.left;
                }
            }
        }

        return res;
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        this.inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        this.inorderTraversal(root.left, res);
        res.add(root.val);
        this.inorderTraversal(root.right, res);
    }
}
