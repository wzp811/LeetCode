package Period.January_2022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while(!stack.isEmpty()){
            cur = stack.pop();
            if((cur.val-p.val)*(cur.val-q.val)<=0) return cur;
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if((cur.val-p.val)*(cur.val-q.val)<=0) return cur;
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
        }
        return root;
    }
}
