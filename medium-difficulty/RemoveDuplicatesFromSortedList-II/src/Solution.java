import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode current = head;

        while (current != null) {
            countMap.put(current.val, countMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode newCurrent = dummy;
        current = head;

        while (current != null) {
            if (countMap.get(current.val) == 1) {
                newCurrent.next = new ListNode(current.val);
                newCurrent = newCurrent.next;
            }
            current = current.next;
        }

        return dummy.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}