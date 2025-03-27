import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            if (temp.next != null) {
                copy.next = map.get(temp.next);
            }
            if (temp.random != null) {
                copy.random = map.get(temp.random);
            }
            temp = temp.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}