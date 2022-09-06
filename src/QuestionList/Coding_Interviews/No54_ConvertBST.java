package QuestionList.Coding_Interviews;

import java.util.Stack;

public class No54_ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
            sum += cur.val;
        }
        TreeNode cur = root.left;
        stack.push(root);
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                sum -= cur.val;
                cur.val += sum;
                cur = cur.right;
            }
        }
        return root;
    }
}
