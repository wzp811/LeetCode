package January_2022;

public class No122_MaxProfit {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len==1) return 0;
        int cur = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) cur += prices[i]-prices[i-1];
        }
        return cur;
    }
}
