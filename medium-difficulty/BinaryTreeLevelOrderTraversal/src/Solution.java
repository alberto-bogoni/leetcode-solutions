import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> result = new ArrayList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> levels = new HashMap<>();

        queue.add(Map.entry(root, 0));

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int level = current.getValue();

            levels.computeIfAbsent(level, k -> new ArrayList<>())
                    .add(node.val);

            if (node.left != null) {
                queue.add(Map.entry(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(Map.entry(node.right, level + 1));
            }
        }

        for (int i = 0; i < levels.size(); i++) {
            result.add(levels.get(i));
        }

        return result;
    }

    public List<List<Integer>> levelOrderSecondApproach(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}