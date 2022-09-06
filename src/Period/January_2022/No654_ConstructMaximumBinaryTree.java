package Period.January_2022;

public class No654_ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int L,int R){
        if(L>R)
            return null;
        if(L==R)
            return new TreeNode(nums[L]);
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=L;i<=R;i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums,L,index-1);
        node.right = constructMaximumBinaryTree(nums,index+1,R);
        return node;
    }
}
