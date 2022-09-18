package LeetCodeContest.Weekly311;

import Period.Hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        if (root.left == null || root.right == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            Deque<TreeNode> tmpDeque = new ArrayDeque<>(deque);
            swapQueue(tmpDeque, flag);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            flag = !flag;
        }
        return root;
    }

    public void swapQueue(Deque<TreeNode> queue, boolean flag) {
        while (queue.size() > 0) {
            if (queue.size() == 1) {
                TreeNode cur = queue.pollLast();
                TreeNode tmp = cur.right;
                cur.right = cur.left;
                cur.left = tmp;
                if (flag) swap(cur);
            } else {
                TreeNode l = queue.pollFirst();
                TreeNode r = queue.pollLast();
                swap(l, r);
                if (flag) {
                    swap(l);
                    swap(r);
                }
            }
        }
    }

    public void swap(TreeNode l, TreeNode r) {
        TreeNode tmp = l.left;
        l.left = r.right;
        r.right = tmp;
        tmp = l.right;
        l.right = r.left;
        r.left = tmp;
    }

    public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
