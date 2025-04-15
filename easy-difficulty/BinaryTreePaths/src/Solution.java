import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        track(root, "", result);
        return result;
    }

    public void track(TreeNode node, String path, List<String> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(path + node.val);
            return;
        }

        track(node.left, path + node.val + "->", res);
        track(node.right, path + node.val + "->", res);
    }

    public List<String> binaryTreePathsSecond(TreeNode root) {
        List<String> result = new ArrayList<>();
        backtrack(root, new StringBuilder(), result);
        return result;
    }

    private void backtrack(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) return;
        int len = path.length();
        path.append(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            backtrack(node.left, path, result);
            backtrack(node.right, path, result);
        }
        path.setLength(len); // Backtrack by resetting length
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}