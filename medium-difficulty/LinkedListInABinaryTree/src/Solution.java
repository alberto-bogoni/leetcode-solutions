import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null && head != null) return false;
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.val == head.val && checkPath(node, head))
                    return true;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return false;
    }

    public boolean checkPath(TreeNode node, ListNode head) {
        if (node == null && head == null) return true;
        if (node != null && head == null) return true;
        if (node == null || head == null) return false;
        if (node.val != head.val) return false;

        return checkPath(node.left, head.next) || checkPath(node.right, head.next);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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