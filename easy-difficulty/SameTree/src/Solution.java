public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p == null && q == null)
            return true;

        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }

    public boolean isSameTreeSecond(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!(p.val == q.val)) return false;

        boolean left = isSameTreeSecond(p.left, q.left);
        if (!left) return false;
        boolean right = isSameTreeSecond(p.right, q.right);

        return right;
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