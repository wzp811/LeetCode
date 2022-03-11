package Coding_Inerviews_2th;

public class No64_SumNums {
    public int sumNums(int n) {
        int ans = n;
        boolean flag = n > 0 && (ans += sumNums(n-1)) > 0;
        return ans;
    }
}
