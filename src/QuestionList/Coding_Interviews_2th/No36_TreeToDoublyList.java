package QuestionList.Coding_Interviews_2th;

public class No36_TreeToDoublyList {
    public TreeNode treeToDoublyList(TreeNode root){
        TreeNode[]ans = process(root);
        ans[0].left = ans[1];
        ans[1].right = ans[0];
        return ans[0];
    }

    public TreeNode[] process(TreeNode root){
        TreeNode[] ans = new TreeNode[2];
        if(root.left==null) {
            ans[0] = root;
        }
        else {
            TreeNode[] left = process(root.left);
            root.left = left[1];
            left[1].right = root;
            ans[0] = left[0];
        }
        if(root.right==null) {
            ans[1] = root;
        }
        else {
            TreeNode[] right = process(root.right);
            root.right = right[0];
            right[0].left = root;
            ans[1] = right[1];
        }
        return ans;
    }
}
