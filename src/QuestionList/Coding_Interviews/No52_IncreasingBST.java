package QuestionList.Coding_Interviews;

public class No52_IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        return process(root)[0];
    }
    public TreeNode[] process(TreeNode root) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode []res = new TreeNode[2];
        TreeNode []last;
        TreeNode []next;
        last = process(root.left);
        next = process(root.right);
        if (last[1] != null) last[1].right = root;
        if (next[0] != null) root.right = next[0];
        root.left = null;
        res[0] = last[0] == null ? root : last[0];
        res[1] = next[1] == null ? root : next[1];
        return res;
    }
}
