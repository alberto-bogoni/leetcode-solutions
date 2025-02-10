import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = nodes.poll();

                if (!nodes.isEmpty() && i != levelSize - 1)
                    node.next = nodes.peek();

                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}