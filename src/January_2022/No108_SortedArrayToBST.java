package January_2022;

public class No108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        TreeNode root = create(nums,0,nums.length-1);
        return root;
    }
    public TreeNode create(int []nums,int L,int R){
        if(L>R) return null;
        int mid = L+((R-L)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums,L,mid-1);
        root.right = create(nums,mid+1,R);
        return root;
    }
}
