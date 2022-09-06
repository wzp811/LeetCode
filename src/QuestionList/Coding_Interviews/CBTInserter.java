package QuestionList.Coding_Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    TreeNode root = null;
    Queue<TreeNode> queue;
    TreeNode appendNode = null;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = queue.poll();
        while (cur.left != null && cur.right != null) {
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            cur = queue.poll();
        }
        if (cur.left != null) queue.add(cur.left);
        appendNode = cur;
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        TreeNode res = appendNode;
        if (appendNode.left == null) {
            appendNode.left = newNode;
        } else if (appendNode.right == null) {
            appendNode.right = newNode;
            appendNode = queue.poll();
        }
        queue.add(newNode);
        return res.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
