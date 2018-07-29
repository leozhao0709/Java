package _081_120._108_convertSortedArraytoBST;

class ConvertSortedArrayToBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return this.sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = this.sortedArrayToBST(nums, start, mid - 1);
        root.right = this.sortedArrayToBST(nums, mid+1, end);

        return root;
    }
}
