package Period.January_2022;

public class No669_TrimBST {
    public TreeNode trimBST(TreeNode root,int low,int high){
        if(root==null) return null;
        if(root.val<low){
            return root.right;
        }else if(root.val>high){
            return root.left;
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
