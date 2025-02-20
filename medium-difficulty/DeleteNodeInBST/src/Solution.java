public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right != null && root.left == null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
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