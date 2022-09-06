package Period.February_2022;

public class No337_Rob {
    public int rob(TreeNode root){
        int[] res = travel(root);
        return Math.max(res[0],res[1]);
    }
    public int[] travel(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = travel(root.left);
        int[] right = travel(root.right);
        int noselect = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        int select = left[0]+right[0]+root.val;
        return new int[]{noselect,select};
    }

    public static void main(String[] args) {
        No337_Rob obj = new No337_Rob();
        TreeNode t = new TreeNode();

    }
}
