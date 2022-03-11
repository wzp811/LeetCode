package Coding_Inerviews_2th;

public class No46_TranslateNum {
    public int translateNum(int num){
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        for(int i=2;i<=str.length();i++){
            if(str.charAt(i-2)<='1'||str.charAt(i-2)=='2'&&str.charAt(i-1)<='5') dp[i] = dp[i-1]+dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[str.length()];
    }
}
