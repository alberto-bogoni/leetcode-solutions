import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int minLevel = 1;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.poll();

                if (node.left == null && node.right == null)
                    return minLevel;

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null)
                    nodes.add(node.right);
            }
            minLevel++;
        }

        return minLevel;
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