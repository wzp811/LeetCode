package QuestionList.QuestOfTheDay;

import java.util.Deque;
import java.util.LinkedList;

public class No653_FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> ld = new LinkedList<>(), rd = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            ld.addLast(cur);
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            rd.addLast(cur);
            cur = cur.right;
        }
        TreeNode left = ld.peekLast(), right = rd.peekLast();
        while (left.val < right.val) {
            if (left.val + right.val == k) {
                return true;
            } else if (left.val + right.val < k) {
                left = getNext(ld, true);
            } else if (left.val + right.val > k) {
                right = getNext(rd, false);
            }
        }
        return false;
    }

    public TreeNode getNext(Deque<TreeNode> d, boolean isLeft) {
        TreeNode cur = d.pollLast();
        TreeNode node = isLeft ? cur.right : cur.left;
        while (node != null) {
            d.addLast(node);
            node = isLeft ? node.left : node.right;
        }
        return d.peekLast();
    }
}
