package QuestionList.Coding_Interviews;

public class No47_PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (!process(root)) return null;
        return root;
    }
    public boolean process(TreeNode root) {
        if (root == null) return false;
        boolean left = process(root.left);
        boolean right = process(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;
        if (root.val == 1) return true;
        else return left || right;
    }
}
