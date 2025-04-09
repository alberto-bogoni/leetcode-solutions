public class Solution {
    int count = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return val;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);
        count++;
        if (k == count) {
            val = root.val;
            return;
        }
        inorder(root.right, k);
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