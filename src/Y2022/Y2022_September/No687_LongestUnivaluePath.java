package Y2022.Y2022_September;

import Hot100.TreeNode;

public class No687_LongestUnivaluePath {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) left1 = left + 1;
        if (root.right != null && root.right.val == root.val) right1 = right + 1;
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}
