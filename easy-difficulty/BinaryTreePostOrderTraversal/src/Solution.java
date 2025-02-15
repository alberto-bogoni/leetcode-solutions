import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> result = new LinkedList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> order) {
        if (root == null)
            return;

        postorder(root.left, order);
        postorder(root.right, order);
        order.add(root.val);
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