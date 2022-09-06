package Period.February_2022;

public class No416_CanPartition {
    public boolean canPartition1(int[] nums){
        int row = nums.length;
        int sum = 0;
        for(int i=0;i<row;i++){
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        int col = sum/2+1;
        int[][]dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0){
                    dp[i][j] = 0;
                }else if(i==0){
                    dp[i][j] = j>=nums[i]?nums[i]:0;
                }else{
                    if(j<nums[i]) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        return dp[row-1][col-1]==col-1;
    }

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        if(sum%2!=0) return false;
        int[]dp = new int[sum/2+1];
        for(int i=0;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--) dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
        }
        for(int i=0;i<sum/2;i++) System.out.print(dp[i]+" ");
        System.out.println();
        return dp[sum/2]==sum/2;
    }

    public static void main(String[] args) {
        No416_CanPartition obj = new No416_CanPartition();
//        int[] nums = new int[]{1,5,11,5};
        int[] nums = new int[]{1,2,3,5};
        System.out.println(obj.canPartition(nums));
    }
}
