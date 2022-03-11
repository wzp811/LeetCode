package Coding_Inerviews_2th;

public class No55_2_IsBalanced {
    public boolean isBalanced(TreeNode root){
        return maxDepth(root)!=-1;
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left==-1||right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
