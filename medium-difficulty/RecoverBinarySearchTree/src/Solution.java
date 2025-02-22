public class Solution {
    private TreeNode previous = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        inorder(root);

        if (first == null || second == null)
            return;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (previous != null && previous.val > root.val) {
            if (first == null)
                first = previous;
            second = root;
        }
        previous = root;

        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}