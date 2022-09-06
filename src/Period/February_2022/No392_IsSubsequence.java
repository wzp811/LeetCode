package Period.February_2022;

import java.util.Arrays;

public class No392_IsSubsequence {
    public boolean isSubsequence(String s,String t){
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(dp[i],false);
        dp[0][0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        No392_IsSubsequence obj = new No392_IsSubsequence();
        System.out.println(obj.isSubsequence("axc","ahbgdc"));
    }
}
