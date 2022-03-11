package Coding_Interviews_2th;

public class No68_2_LowestCommonAncestor {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        processShit(root, p, q);
        return ans;
    }

    public boolean processShit(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (ans != null) return true;
        boolean left = false;
        boolean right = false;
        if (root == p || root == q) {
            left = processShit(root.left, p, q);
            right = processShit(root.right, q, p);
            if (left || right) {
                ans = root;
            }
            return true;
        }
        left = processShit(root.left, p, q);
        right = processShit(root.right, q, p);
        if (left && right) {
            ans = root;
            return true;
        }
        return false;
    }

    public boolean process(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        boolean left = process(root.left,p,q);
        boolean right = process(root.right,p,q);
        if(ans!=null) return true;
        if(root==p||root==q) {
            if(left||right){
                ans = root;
            }
            return true;
        }else if(left&&right){
            ans = root;
            return true;
        }else{
            return left||right;
        }
    }
}
