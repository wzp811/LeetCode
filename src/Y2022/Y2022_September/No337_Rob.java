package Y2022.Y2022_September;


import Period.Hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No337_Rob {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int select = left[1] + right[1] + root.val;
        int noselect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{select, noselect};
    }
}
