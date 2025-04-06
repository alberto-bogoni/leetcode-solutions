import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.val == subRoot.val && checkSubtree(node, subRoot)) {
                    return true;
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return false;
    }

    public boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if ((subRoot == null && root != null) || (root == null && subRoot != null)) return false;
        if (root.val != subRoot.val) return false;

        return checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
    }

    public boolean isSubtreeSecond(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val && equals(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equals(TreeNode node, TreeNode subnode) {
        if (node == null && subnode == null) return true;
        if (node == null || subnode == null) return false;
        if (node.val != subnode.val) return false;
        return equals(node.left, subnode.left) && equals(node.right, subnode.right);
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