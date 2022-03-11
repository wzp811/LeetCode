package Coding_Inerviews_2th;

import java.util.Stack;

public class No26_IsSubStructure {
    public boolean isSubStructure(TreeNode A,TreeNode B){
        if(A==null||B==null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.val==B.val&&process(cur,B)) return true;
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        return false;
    }
    public boolean process(TreeNode A,TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;
        return process(A.left,B.left)&&process(A.right,B.right);
    }

}
