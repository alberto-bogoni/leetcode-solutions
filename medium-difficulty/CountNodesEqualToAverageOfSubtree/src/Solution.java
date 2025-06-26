public class Solution {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return count;
    }

    class AvgTree {
        public int sum = 0;
        public int num = 0;

        public AvgTree(int s, int n) {
            this.sum = s;
            this.num = n;
        }
    }

    public AvgTree avg(TreeNode root) {
        if (root == null) return new AvgTree(0,0);

        AvgTree left = avg(root.left);
        AvgTree right = avg(root.right);

        int total = left.sum + right.sum + root.val;
        int n = left.num + right.num + 1;
        if (total / n == root.val) count++;

        return new AvgTree(total, n);
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