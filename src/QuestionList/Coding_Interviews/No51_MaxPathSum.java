package QuestionList.Coding_Interviews;

public class No51_MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }
    public int process(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) left = process(root.left);
        if (root.right != null) right = process(root.right);
        if (max < left + right + root.val) max = left + right + root.val;
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
