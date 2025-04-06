public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode node = build(root, null, val);
            if (node.val > val) {
                node.left = new TreeNode(val);
            } else {
                node.right = new TreeNode(val);
            }
        }

        return root;
    }

    public TreeNode build(TreeNode root, TreeNode parent, int val) {
        if (root == null) return parent;
        if (val < root.val) return build(root.left, root, val);
        else return build(root.right, root, val);
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