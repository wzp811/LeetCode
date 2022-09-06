package Period.Hot100;


public class No124_MaxPathSum {
    int max = Integer.MIN_VALUE;
    int min = 0;
    public int maxPathSum(TreeNode root){
        process(root);
        return max;
    }
    public int process(TreeNode root){
        if(root==null) return 0;
        int left = process(root.left);
        int right = process(root.right);
        max = Math.max(max,left+right+root.val);
        return Math.max(Math.max(Math.max(left,right),0)+root.val,0);
    }
    public int[] process1(TreeNode root){
        if(root==null) return new int[]{min,min,min,min};
        int []res = new int[4];
        int []left = process1(root.left);
        int []right = process1(root.right);
        res[0] = root.val;
        res[1] = Math.max(left[0],Math.max(left[1],left[2]))+res[0];
        res[2] = Math.max(right[0],Math.max(right[1],right[2]))+res[0];
        res[3] = res[1]+res[2]-res[0];
        max = Math.max(res[3],max);
        return res;
    }
}
