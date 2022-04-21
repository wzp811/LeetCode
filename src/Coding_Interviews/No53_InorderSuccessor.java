package Coding_Interviews;

public class No53_InorderSuccessor {
    boolean hasFind = false;
    TreeNode res = null;
    TreeNode p = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.p = p;
        process(root);
        return res;
    }
    public void process(TreeNode root) {
        if (root == null) return;
        process(root.left);
        if (hasFind && res == null) res = root;
        if (root == this.p) hasFind = true;
        process(root.right);
    }
}
