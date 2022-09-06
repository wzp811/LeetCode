package Period.January_2022;

import java.util.Stack;

public class No530_GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        stack.push(root);
        TreeNode cur = root.left;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(Math.abs(cur.val-last)<res) res = Math.abs(cur.val-last);
                last = cur.val;
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No530_GetMinimumDifference obj = new No530_GetMinimumDifference();

    }
}
