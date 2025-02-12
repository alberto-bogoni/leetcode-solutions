import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return List.of();

        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return List.of(List.of(root.val));
        
        List<List<Integer>> paths = new LinkedList<>();
        findPath(root, targetSum, new LinkedList<Integer>(), paths);

        return paths;
    }

    public void findPath(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> paths) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left == null && root.right == null && targetSum - root.val == 0)
            paths.add(new LinkedList<Integer>(list));

        findPath(root.left, targetSum - root.val, list, paths);
        findPath(root.right, targetSum - root.val, list, paths);

        list.remove(list.size() - 1);
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