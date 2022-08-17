package Y2022.Y2022_August;

import Hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                sum += cur.val;
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
        }
        return sum;
    }
}
