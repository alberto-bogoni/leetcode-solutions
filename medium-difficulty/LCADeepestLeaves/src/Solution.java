public class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        int maxDepth = maxDepth(root, 0);
        return lca(root, 0, maxDepth);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

    public TreeNode lca(TreeNode root, int depth, int maxDepth) {
        if (root == null || depth == maxDepth - 1) {
            return root;
        }

        TreeNode left = lca(root.left, depth + 1, maxDepth);
        TreeNode right = lca(root.right, depth + 1, maxDepth);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
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