import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> result = new LinkedList<>();
        Stack<List<Integer>> levels = new Stack<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        levels.push(List.of(root.val));

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodes.poll();

                if (currentNode.left != null) {
                    nodes.add(currentNode.left);
                    level.add(currentNode.left.val);
                }

                if (currentNode.right != null) {
                    nodes.add(currentNode.right);
                    level.add(currentNode.right.val);
                }
            }
            if (!level.isEmpty())
                levels.push(level);
        }

        int size = levels.size();
        for (int i = 0; i < size; i++) {
            result.add(levels.pop());
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottomSecondApproach(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodes.poll();
                level.add(currentNode.val);

                if (currentNode.left != null) {
                    nodes.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.add(currentNode.right);
                }
            }
            result.add(0, level);
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