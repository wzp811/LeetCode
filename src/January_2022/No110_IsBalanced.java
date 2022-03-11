package January_2022;

public class No110_IsBalanced {
    public boolean isBalanced(TreeNode root){
        return getHeight(root)!=-1;
    }
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1||leftHeight==-1||rightHeight==-1)
            return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
