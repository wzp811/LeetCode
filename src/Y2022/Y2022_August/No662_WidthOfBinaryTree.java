package Y2022.Y2022_August;

import Coding_Interviews.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No662_WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int res = 1;
        int left = -1, right = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node == null) {
                    queue.addLast(null);
                    queue.addLast(null);
                } else {
                    if (left == -1) left = i;
                    right = i;
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
