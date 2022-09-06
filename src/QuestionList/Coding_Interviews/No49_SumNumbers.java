package QuestionList.Coding_Interviews;

import java.util.Stack;

public class No49_SumNumbers {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        return process(root, 0);
    }
    public int process(TreeNode root, int num) {
        num = num * 10 + root.val;
        int sum = 0;
        if (root.left == null && root.right == null) return num;
        if (root.left != null) sum += process(root.left, num);
        if (root.right != null) sum += process(root.right, num);
        return sum;
    }
}
