package QuestionList.QuestOfTheDay;

import java.util.Deque;
import java.util.LinkedList;

public class No965_IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur.val != val) return false;
            if (cur.left != null) queue.addLast(cur.left);
            if (cur.right != null) queue.addLast(cur.right);
        }
        return true;
    }
}
