public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return checkBalance(root).balanced;
    }

    public Result checkBalance(TreeNode root) {
        if (root == null) return new Result(0, true);

        Result leftResult = checkBalance(root.left);
        Result rightResult = checkBalance(root.right);

        boolean isBalanced = leftResult.balanced
                && rightResult.balanced
                && (Math.abs(leftResult.height - rightResult.height) <= 1);

        int height = 1 + Math.max(leftResult.height, rightResult.height);
        return new Result(height, isBalanced);
    }

    class Result {
        Integer height;
        Boolean balanced;

        public Result(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public class TreeNode {
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
}