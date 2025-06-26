import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int listLength = 0;
        ListNode copy = head;
        while (copy != null) {
            listLength++;
            copy = copy.next;
        }

        int[] ans = new int[listLength];
        Stack<ListNode> stack = new Stack<>();

        int pos = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        copy = head;
        while (copy != null) {
            while (!stack.isEmpty() && stack.peek().val < copy.val) {
                map.put(stack.pop(), copy.val);
            }

            stack.push(copy);
            copy = copy.next;
        }

        int count = 0;
        while (head != null && count < listLength) {
            ans[count] = map.getOrDefault(head, 0);
            head = head.next;
            count++;
        }
        return ans;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}