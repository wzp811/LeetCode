package Coding_Inerviews_2th;

public class No28_IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return judge(root.left,root.right);
    }
    public boolean judge(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return judge(left.left,right.right)&&judge(left.right,right.left);
    }
}
