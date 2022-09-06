package Y2022.Y2022_July;

import Period.Hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1161_MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int maxLevel = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int level = 1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                sum += cur.val;
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
