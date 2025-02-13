public class Solution {
    private int treeDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeDiameter = 0;
        calculateHeight(root);
        return treeDiameter;
    }

    private int calculateHeight(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);

        if (leftTreeHeight != 0 || rightTreeHeight != 0) {
            int diameter = leftTreeHeight + rightTreeHeight;
            treeDiameter = Math.max(treeDiameter, diameter);
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
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