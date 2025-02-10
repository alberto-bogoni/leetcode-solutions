import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public TreeNode connect(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode previous = null;
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.poll();

                if (previous != null) {
                    previous.next = node;
                }
                previous = node;

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null)
                    nodes.add(node.right);
            }

        }

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }

    ;
}