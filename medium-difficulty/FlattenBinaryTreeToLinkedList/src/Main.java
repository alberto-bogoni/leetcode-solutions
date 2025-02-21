import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        List<Integer> list = new LinkedList<>();

        build(root, list);

        ListIterator<Integer> it = list.listIterator();
        root.val = it.next();  // Set first value
        TreeNode current = root;

        while (it.hasNext()) {
            current.left = null;
            current.right = current.right != null ? current.right : new TreeNode(0);
            current.right.val = it.next();
            current = current.right;
        }

        current.left = null;
        current.right = null;
    }

    public void build(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);

        build(root.left, list);
        build(root.right, list);
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