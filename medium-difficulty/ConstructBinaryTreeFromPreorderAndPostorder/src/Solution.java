import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> postMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int postL, int postR) {
        if (postL > postR) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postL == postR) return root;

        int leftChildPostIndex = postMap.get(preorder[preIndex]);

        root.left = build(preorder, postL, leftChildPostIndex);
        root.right = build(preorder, leftChildPostIndex + 1, postR - 1);

        return root;
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