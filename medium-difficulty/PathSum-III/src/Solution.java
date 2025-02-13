import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> currentPath= new LinkedList<>();
        return numberOfPaths(root, targetSum, currentPath);
    }

    public int numberOfPaths(TreeNode root, int targetSum, List<Integer> currentPath) {
        if (root == null)
            return 0;

        currentPath.add(root.val);

        int pathCount = 0;
        double pathSum = 0;
        for (int i = currentPath.size() - 1; i >= 0; i--) {
            pathSum += currentPath.get(i);

            if (pathSum == targetSum)
                pathCount++;
        }

        pathCount += numberOfPaths(root.left, targetSum, currentPath);
        pathCount += numberOfPaths(root.right, targetSum, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
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