public class Solution {
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}