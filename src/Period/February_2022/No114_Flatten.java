package Period.February_2022;

public class No114_Flatten {
    public void flatten(TreeNode root){
        root = calc(root);
    }
    public TreeNode calc(TreeNode root){
        if(root==null) return root;
        if(root.left==null) {
            root.right = calc(root.right);
            return root;
        }
        TreeNode right = calc(root.right);
        root.right = calc(root.left);
        root.left = null;
        TreeNode cur = root;
        while(cur.right!=null) cur = cur.right;
        cur.right = right;
        return root;
    }
}
