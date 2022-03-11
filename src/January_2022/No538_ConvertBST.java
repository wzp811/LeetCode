package January_2022;

import java.util.Stack;

public class No538_ConvertBST {
    int sum = 0;
    public TreeNode convertBST1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        TreeNode cur = root.right;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur.right);
                cur = cur.right;
            }else{
                cur = stack.pop();
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
    public TreeNode convertBST(TreeNode root){
        convertBST(root);
        return root;
    }
    public void convertBST2(TreeNode root){
        if(root==null) return;
        convertBST2(root.right);
        sum += root.val;
        root.val = sum;
        convertBST2(root.left);
    }
}
