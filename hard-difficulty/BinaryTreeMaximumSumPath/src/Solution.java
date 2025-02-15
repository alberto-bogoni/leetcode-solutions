class Solution {
    int globalMaximumSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private int findMaximumPathSumRecursive(TreeNode root) {
        if (root == null)
            return 0;

        int maxPathSumFromLeft = findMaximumPathSumRecursive(root.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(root.right);

        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + root.val;
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + root.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
