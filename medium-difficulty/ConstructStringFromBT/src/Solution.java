public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("");
            return;
        }

        sb.append(root.val);
        if (root.left != null || (root.left == null && root.right != null)) {
            sb.append("(");
            preorder(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
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