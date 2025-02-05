import java.util.Stack;

public class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();

        while (head != null) {
            while (!s.isEmpty() && s.peek().val < head.val)
                s.pop();

            if (!s.isEmpty()) {
                s.peek().next = head;
            }
            s.push(head);
            head = head.next;
        }

        return s.isEmpty() ? null : s.get(0);
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