package Period.February_2022;

import java.util.Arrays;

public class No647_CountSubstrings {
    public int countSubstrings1(String s){
        int[] dp = new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            dp[i] = dp[i-1];
            for(int j=i;j>0;j--){
                if(s.charAt(i-1)==s.charAt(j-1)){
                    int l = i-1;
                    int r = j-1;
                    boolean flag = true;
                    while(r>l){
                        if(s.charAt(r--)!=s.charAt(l++)){
                            flag = false;
                            break;
                        }
                    }
                    dp[i] += flag?1:0;
                }
            }
        }
        for(int i=0;i<=s.length();i++) System.out.print(dp[i]+" ");
        System.out.println();
        return dp[s.length()];
    }
    public int countSubstrings(String s){
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++) {
            Arrays.fill(dp[i], false);
            dp[i][i] = true;
        }
        int count = s.length();
        for(int i=s.length();i>=1;i--){
            for(int j=i+1;j<=s.length();j++){
                dp[i][j] = s.charAt(i-1)==s.charAt(j-1)&&(j==i+1||dp[i+1][j-1]);
                count += dp[i][j]?1:0;
            }
        }
//        for(int i=1;i<=s.length();i++){
//            for(int j=i+1;j<=s.length();j++){
//                dp[i][j] = s.charAt(i-1)==s.charAt(j-1)&&(j==i+1||dp[i+1][j-1]);
//                count += dp[i][j]?1:0;
//            }
//        }
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=s.length();j++) System.out.print("\t"+dp[i][j]);
            System.out.println();
        }
        return count;
    }

    public static void main(String[] args) {
        No647_CountSubstrings obj = new No647_CountSubstrings();
        System.out.println(obj.countSubstrings("aaa"));
    }
}
