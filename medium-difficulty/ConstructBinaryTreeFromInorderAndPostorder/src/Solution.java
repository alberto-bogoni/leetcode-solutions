import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int pIdx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;

        int pVal = postorder[pIdx--];
        TreeNode node = new TreeNode(pVal);
        int inIdx = map.get(pVal);
        node.right = build(inorder, postorder, inIdx + 1, end);
        node.left = build(inorder, postorder, start, inIdx - 1);

        return node;
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