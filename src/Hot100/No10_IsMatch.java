package Hot100;

import java.util.Arrays;
import java.util.Stack;

public class No10_IsMatch {
    public boolean isMatch(String s,String p){
        if(p==".*") return true;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(dp[i],false);
        dp[0][0] = true;
        char last = '0';
        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-2];
            for(int i=1;i<=s.length();i++){
                if(p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2]||dp[i][j-1]||(last==s.charAt(i-1)||last=='.')&&dp[i-1][j];
                }else{
                    dp[i][j] = s.charAt(i-1)==p.charAt(j-1)&&dp[i-1][j-1];
                }
            }
            if(p.charAt(j-1)!='*') last = p.charAt(j-1);
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        No10_IsMatch obj = new No10_IsMatch();
        System.out.println(obj.isMatch("aa","a"));
        System.out.println(obj.isMatch("aa","a*"));
        System.out.println(obj.isMatch("ab",".*"));
        System.out.println(obj.isMatch("aab","c*a*b"));
        System.out.println(obj.isMatch("aaa","ab*a*c*a*"));
        System.out.println(obj.isMatch("aaa",".*"));
    }
}
