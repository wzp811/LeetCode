package February_2022;

import java.util.LinkedList;
import java.util.List;

public class No714_MaxProfit {
    public int maxProfit1(int[] prices,int fee){
        int res = 0;
        int cur = prices[0]+fee;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+fee<cur){
                cur = prices[i]+fee;
            }else if(prices[i]>cur){
                res += prices[i]-cur;
                cur = prices[i];
            }
        }
        return res;
    }

    public int maxProfit(int[] prices,int fee){
        int[] dp = new int[2];
        dp[0] = -prices[0]-fee;
        for(int i=1;i<prices.length;i++){
            dp[0] = Math.max(dp[1]-prices[i]-fee,dp[0]);
            dp[1] = Math.max(dp[0]+prices[i],dp[1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        No714_MaxProfit obj = new No714_MaxProfit();
//        int[] prices = new int[]{1,3,2,8,4,9};
        int[] prices = new int[]{1,3,7,5,10,3};
        System.out.println(obj.maxProfit(prices,3));
    }
}
