package February_2022;

public class No1035_MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1,int[] nums2){
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                dp[i][j] = nums1[i-1]==nums2[j-1]?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        No1035_MaxUncrossedLines obj = new No1035_MaxUncrossedLines();
//        int[] nums1 = new int[]{2,5,1,2,5};
//        int[] nums2 = new int[]{10,5,2,1,5,2};
        int[] nums1 = new int[]{1,3,7,1,7,5};
        int[] nums2 = new int[]{1,9,2,5,1};
        System.out.println(obj.maxUncrossedLines(nums1,nums2));
    }
}
