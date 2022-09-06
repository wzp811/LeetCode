package Period.February_2022;

public class No718_FindLength {
    public int findLength(int[] nums1,int[] nums2){
        int[][]dp = new int[nums1.length][nums2.length];
        int max = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                dp[i][j] = nums1[i]==nums2[j]?((i==0||j==0)?1:dp[i-1][j-1]+1):0;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No718_FindLength obj = new No718_FindLength();
//        int[]nums1 = new int[]{1,2,3,2,1};
//        int[]nums2 = new int[]{3,2,1,4,7};
        int[]nums1 = new int[]{0,0,0,0,0};
        int[]nums2 = new int[]{0,0,0,0,0};
        System.out.println(obj.findLength(nums1,nums2));
    }
}
