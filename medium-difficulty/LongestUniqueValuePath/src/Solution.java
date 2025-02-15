import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // integers to store the length values
        int dirRight = 0, dirLeft = 0;

        if(node.left != null && node.left.val == node.val){
            dirLeft += (left + 1);
        }

        if(node.right != null && node.right.val == node.val){
            dirRight += (right + 1);;
        }

        // find max of the count with sum of univalue path
        count = Math.max(count, dirLeft + dirRight);

        return Math.max(dirLeft , dirRight);
    }

    public static class TreeNode {
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
