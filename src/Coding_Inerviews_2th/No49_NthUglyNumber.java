package Coding_Inerviews_2th;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class No49_NthUglyNumber {
    public int nthUglyNumber1(int n){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int []factor = new int[]{2,3,5};
        queue.add((long)1);
        set.add((long)1);
        for(int i=1;i<n;i++){
            long cur = queue.poll();
            for(int j=0;j<3;j++){
                if(!set.contains(factor[j]*cur)){
                    queue.add(factor[j]*cur);
                    set.add(factor[j]*cur);
                }
            }
        }
        long ans = queue.poll();
        return (int)ans;
    }
    public int nthUglyNumber2(int n){
        Set<Long> set = new HashSet<>();
        long[] dp = new long[n+1];
        dp[1] = 1;
        int[] point = new int[]{1,1,1};
        int[] factor = new int[]{2,3,5};
        for(int i=2;i<=n;i++){
            long min = Long.MAX_VALUE;
            int index = -1;
            for(int j=0;j<3;j++){
                while(point[j]<=n&&set.contains(dp[point[j]]*factor[j])) point[j]++;
                if(point[j]>n) continue;
                long cur = dp[point[j]]*factor[j];
                if(cur<min){
                    min = cur;
                    index = j;
                }
            }
            dp[i] = min;
            set.add(min);
            if(index!=-1) point[index]++;
        }
        return (int)dp[n];
    }

    public int nthUglyNumber(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        int[] factor = new int[]{2,3,5};
        int[] pointer = new int[]{1,1,1};
        int[] ans = new int[3];
        for(int i=2;i<=n;i++){
            for(int j=0;j<3;j++) ans[j] = factor[j]*dp[pointer[j]];
            dp[i] = Math.min(Math.min(ans[0],ans[1]),ans[2]);
            for(int j=0;j<3;j++) if(dp[i]==ans[j]) pointer[j]++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No49_NthUglyNumber obj = new No49_NthUglyNumber();
        System.out.println(obj.nthUglyNumber(10));
    }

}
