package Period.January_2022;

public class No404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        return travel(root,false);
    }
    public int travel(TreeNode root,boolean isLeft){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null){
            return isLeft?root.val:0;
        }
        return travel(root.left,true)+travel(root.right,false);
    }
}
