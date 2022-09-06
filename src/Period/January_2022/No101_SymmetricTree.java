package Period.January_2022;

import java.util.LinkedList;
import java.util.Queue;

public class No101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root);
        TreeNode tmp1 = null;
        TreeNode tmp2 = null;
        while(!queue1.isEmpty()){
            tmp1 = queue1.poll();
            tmp2 = queue2.poll();
            if(tmp1.val!=tmp2.val)
                return false;
            if(tmp1.left!=null&&tmp2.right!=null){
                queue1.add(tmp1.left);
                queue2.add(tmp2.right);
            }else if(tmp1.left==null&&tmp2.right!=null||tmp1.left!=null&&tmp2.right==null){
                return false;
            }
            if(tmp1.right!=null&&tmp2.left!=null){
                queue1.add(tmp1.right);
                queue2.add(tmp2.left);
            }else if(tmp1.right==null&&tmp2.left!=null||tmp1.right!=null&&tmp2.left==null){
                return false;
            }
        }
        return true;
    }
    public boolean isSymmetric1(TreeNode root){
        return root==null||isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }else{
            return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }
    }
}
