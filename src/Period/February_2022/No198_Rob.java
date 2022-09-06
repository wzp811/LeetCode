package Period.February_2022;

public class No198_Rob {
    public int rob(int[] nums){
        if(nums.length<=1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        No198_Rob obj = new No198_Rob();
//        int[] nums = new int[]{1,2,3,1};
//        int[] nums = new int[]{2,7,9,3,1};
        int[] nums = new int[]{50,20,100,1000};
        System.out.println(obj.rob(nums));
    }
}
