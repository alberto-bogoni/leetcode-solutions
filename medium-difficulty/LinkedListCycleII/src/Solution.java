import java.util.List;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    private ListNode findStart(ListNode head, int cycleLength) {
        ListNode fast = head;
        ListNode slow = head;

        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    private int calculateCycleLength(ListNode slow) {
        int cycleLength = 0;

        ListNode pointer = slow;

         do {
            pointer = pointer.next;
            cycleLength++;
        } while (pointer != slow);

        return cycleLength;
    }
}
