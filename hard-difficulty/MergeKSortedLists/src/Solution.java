import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 0 -> value
        // 1 -> list
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                minHeap.add(new int[]{lists[i].val, i});
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (!minHeap.isEmpty()) {
            int[] item = minHeap.poll();

            current.next = new ListNode(item[0]);
            current = current.next;

            if (lists[item[1]].next != null) {
                ListNode next = lists[item[1]].next;
                lists[item[1]] = next;
                minHeap.add(new int[]{lists[item[1]].val, item[1]});
            }
        }

        return result.next;
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