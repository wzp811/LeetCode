package Y2022_July;

import Coding_Interviews.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No623_AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        TreeNode cur = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(cur);
        for (int i = 0; i < depth; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                if (i == depth - 1) {
                    TreeNode ll = new TreeNode(val);
                    TreeNode rr = new TreeNode(val);
                    ll.left = node.left;
                    rr.right = node.right;
                    node.left = ll;
                    node.right = rr;
                }
            }
        }
        return root;
    }
}
