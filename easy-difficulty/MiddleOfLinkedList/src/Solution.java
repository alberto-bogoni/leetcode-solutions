public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast.next == null) {
                return slow;
            }
            if (fast.next.next == null) {
                return slow.next;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
    }
}
