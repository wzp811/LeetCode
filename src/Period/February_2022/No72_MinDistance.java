package Period.February_2022;

public class No72_MinDistance {
    public int minDistance(String word1,String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) dp[i][0] = i;
        for(int j=0;j<=word2.length();j++) dp[0][j] = j;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                dp[i][j] = word1.charAt(i-1)==word2.charAt(j-1)?dp[i-1][j-1]:Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        No72_MinDistance obj = new No72_MinDistance();
        System.out.println(obj.minDistance("horse","ros"));
        System.out.println(obj.minDistance("intention","execution"));
    }
}
