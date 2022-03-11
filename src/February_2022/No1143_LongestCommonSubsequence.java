package February_2022;

public class No1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1,String text2){
        int[][]dp = new int[text1.length()+1][text2.length()+1];
        dp[0][0] = 0;
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<= text2.length();j++){
                dp[i][j] = text1.charAt(i-1)==text2.charAt(j-1)?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        No1143_LongestCommonSubsequence obj = new No1143_LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("abc","def"));
    }
}
