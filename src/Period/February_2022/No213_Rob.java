package Period.February_2022;

public class No213_Rob {
    public int rob(int[] nums){
        if(nums.length<=1) return nums[0];
        int[]dp1 = new int[nums.length];
        int[]dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++) dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i=2;i<nums.length;i++) dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        return Math.max(nums[nums.length-1],nums[nums.length-2]);
    }
}
