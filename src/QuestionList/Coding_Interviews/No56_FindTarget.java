package QuestionList.Coding_Interviews;

import java.util.Deque;
import java.util.LinkedList;

public class No56_FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> leftStack = new LinkedList<>();
        Deque<TreeNode> rightStack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            leftStack.push(cur);
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            rightStack.push(cur);
            cur = cur.right;
        }
        TreeNode left = getNext(leftStack, true);
        TreeNode right = getNext(rightStack, false);
        while (left != right) {
            if (left.val + right.val > k) {
                right = getNext(rightStack, false);
            } else if (left.val + right.val < k) {
                left = getNext(leftStack, true);
            } else {
                return true;
            }
        }
        return false;
    }

    public TreeNode getNext(Deque<TreeNode> stack, boolean isLeft) {
        TreeNode res = stack.poll();
        TreeNode cur = isLeft ? res.right : res.left;
        while (cur != null) {
            stack.push(cur);
            cur = isLeft ? cur.left : cur.right;
        }
        return res;
    }
}
