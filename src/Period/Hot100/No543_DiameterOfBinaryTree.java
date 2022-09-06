package Period.Hot100;

public class No543_DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        travel(root);
        return max;
    }
    public int travel(TreeNode root){
        if(root==null) return 0;
        int left = travel(root.left);
        int right = travel(root.right);
        max = Math.max(left+right+1,max);
        return Math.max(left,right)+1;
    }
}
