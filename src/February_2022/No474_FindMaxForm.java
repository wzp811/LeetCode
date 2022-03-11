package February_2022;

import java.util.LinkedList;
import java.util.List;

public class No474_FindMaxForm {
    public int findMaxForm(String[] strs,int m,int n){
        int[][]dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=0;i<strs.length;i++){
            int count0 = 0;
            int count1 = 0;
            for(int j=0;j<strs[i].length();j++) if(strs[i].charAt(j)=='0') count0++;
            count1 = strs[i].length() - count0;
            for(int j=m;j>=count0;j--){
                for(int k=n;k>=count1;k--){
                    dp[j][k] = Math.max(dp[j-count0][k-count1]+1,dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        No474_FindMaxForm obj = new No474_FindMaxForm();
//        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        String[] strs = new String[]{"10", "0", "1"};
        System.out.println(obj.findMaxForm(strs,1,1));
    }
}
