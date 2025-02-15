import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return List.of();

        List<Integer> result = new LinkedList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> order) {
        if (root == null)
            return;

        inorder(root.left, order);
        order.add(root.val);
        inorder(root.right, order);
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