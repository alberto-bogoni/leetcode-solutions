public class Solution {
    public ListNode swapPairs(ListNode head) {
        int count = 1;

        ListNode current = head;
        ListNode prev = null;
        ListNode beforePair = null;
        while (current != null) {

            if (count % 2 == 0) {
                ListNode next = current.next;
                prev.next = next;
                current.next = prev;
                if (beforePair != null) {
                    beforePair.next = current;
                } else
                    head = current;
                current = prev;
                beforePair = current;
            }

            prev = current;
            current = current.next;
            count++;
        }

        return head;
    }
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}