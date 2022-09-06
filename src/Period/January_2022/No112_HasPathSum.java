package Period.January_2022;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No112_HasPathSum {
    public boolean hasPathSum1(TreeNode root,int targetSum){
        if(root==null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> target = new Stack<>();
        stack.push(root);
        targetSum -= root.val;
        target.push(targetSum);
        TreeNode node = null;
        int targetTmp = 0;
        while(!stack.isEmpty()){
            node = stack.pop();
            targetTmp = target.pop();
            if(node.left==null&&node.right==null&&targetTmp==0)
                return true;
            targetSum += node.val;
            if(node.left!=null){
                stack.push(node.left);
                target.push(targetTmp-node.left.val);
            }
            if(node.right!=null){
                stack.push(node.right);
                target.push(targetTmp-node.right.val);
            }
        }
        return targetTmp==0;
    }
    public boolean hasPathSum(TreeNode root,int targetSum){
        if(root==null) return false;
        if(root.left==null&&root.right==null) return targetSum-root.val==0;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    public static void main(String[] args) {
        No112_HasPathSum obj = new No112_HasPathSum();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        TreeNode.createTree(l);

    }
}
