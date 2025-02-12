public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int[] total = new int[1];
        findRootToLeafPathNumbers(root, new StringBuilder(), total);
        return total[0];
    }

    public int sumNumbersSecondApproach(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private void findRootToLeafPathNumbers(TreeNode root, StringBuilder sb, int[] total) {
        if (root == null) {
            return;
        }

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            total[0] += Integer.parseInt(sb.toString());
        }

        findRootToLeafPathNumbers(root.left, sb, total);
        findRootToLeafPathNumbers(root.right, sb, total);

        sb.setLength(sb.length() - 1);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null)
            return 0;

        pathSum = 10 * pathSum + currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
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