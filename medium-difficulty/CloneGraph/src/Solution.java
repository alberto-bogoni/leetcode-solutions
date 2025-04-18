import java.util.*;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return dfs(node, new HashMap<Node, Node>());
    }

    public Node bfs(Node node) {
        Node start = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (visited.getOrDefault(polled.val, false)) continue;

            Node root = map.getOrDefault(polled.val, new Node(polled.val));
            map.put(root.val, root);
            visited.put(root.val, true);
            if (start == null) start = root;

            List<Node> neig = new LinkedList<>();
            for (int i = 0; i < polled.neighbors.size(); i++) {
                Node n = polled.neighbors.get(i);
                Node newN = map.getOrDefault(n.val, new Node(n.val));
                map.put(newN.val, newN);
                neig.add(newN);
                queue.add(n);
            }
            root.neighbors.addAll(neig);
        }

        return start;
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(dfs(node.neighbors.get(i), map));
        }

        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}