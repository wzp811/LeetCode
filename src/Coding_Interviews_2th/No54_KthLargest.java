package Coding_Interviews_2th;

import java.util.Stack;

public class No54_KthLargest {
    public int kthLargest(TreeNode root,int k){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root.right;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.right;
            }else{
                cur = stack.pop();
                k--;
                if(k==0) return cur.val;
                cur = cur.left;
            }
        }
        return 1;
    }
}
