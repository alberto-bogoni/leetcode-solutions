public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head);
    }

    public TreeNode build(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        TreeNode node = new TreeNode(mid.val);
        if (prev != null) {
            prev.next = null;
            node.left = build(head);
        } else {
            node.left = null;
        }
        node.right = build(mid.next);

        return node;
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

   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}