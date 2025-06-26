public class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            prev = node;
            node = next;
        }
        prev.next = null;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}