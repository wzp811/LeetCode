package January_2022;

public class No701_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            insert(root, val);
        }
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        }
    }
}