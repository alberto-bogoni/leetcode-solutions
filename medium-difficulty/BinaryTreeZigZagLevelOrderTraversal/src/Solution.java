import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return List.of();

        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean leftToRight = true;
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }
            leftToRight = !leftToRight;
            result.add(level);
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