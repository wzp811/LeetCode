package QuestionList.Coding_Interviews_2th;

public class No27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root){
        if(root==null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
