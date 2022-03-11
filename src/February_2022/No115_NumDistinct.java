package February_2022;

public class No115_NumDistinct {
    public int numDistinct(String s,String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) dp[i][0] = 1;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                dp[i][j] = s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]+dp[i-1][j]:dp[i-1][j];
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        No115_NumDistinct obj = new No115_NumDistinct();
        System.out.println(obj.numDistinct("babgbag","bag"));
        System.out.println(obj.numDistinct("rabbbit","rabbit"));
    }
}
