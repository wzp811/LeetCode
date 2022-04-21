package Coding_Interviews;

import java.util.Stack;

public class BSTIterator {
    TreeNode root = null;
    Stack<TreeNode> stack;
    TreeNode cur = null;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        stack.push(root);
        cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ans = cur.val;
        cur = cur.right;
        return ans;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
