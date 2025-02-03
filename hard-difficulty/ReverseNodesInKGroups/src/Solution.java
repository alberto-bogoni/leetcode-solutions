public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        int count = 0;

        ListNode it = head;
        int listLength = 0;
        while (it != null) {
            it = it.next;
            listLength++;
        }

        ListNode beforeSublist = null;
        ListNode lastSublist = null;
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null && current.next != null) {

            int i = 0;
            beforeSublist = lastSublist;
            lastSublist = current;

            while (current != null && i < k) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
                count++;
            }

            lastSublist.next = current;
            if (beforeSublist != null)
                beforeSublist.next = previous;
            else
                head = previous;

            if ((listLength - count) < k)
                break;
        }

        return head;
    }

    public static class ListNode {
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