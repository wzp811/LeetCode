package Y2022.Y2022_July;

import QuestionList.Coding_Interviews.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CBTInserter {

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur.left == null) {
                cur.left = node;
                return cur.val;
            } else if (cur.right == null) {
                cur.right = node;
                return cur.val;
            } else {
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }
        }
        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
}
