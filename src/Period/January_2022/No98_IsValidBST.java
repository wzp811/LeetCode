package Period.January_2022;

public class No98_IsValidBST {
    public TreeNode pre = null;
    public boolean isValidBST(TreeNode root){
        if(root==null) return true;
        boolean leftValid = isValidBST(root.left);
        if(pre!=null&&pre.val>=root.val) return false;
        pre = root;
        boolean rightValid = isValidBST(root.right);
        return leftValid&rightValid;
    }
}
