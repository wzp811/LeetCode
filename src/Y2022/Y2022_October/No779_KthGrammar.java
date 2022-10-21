package Y2022.Y2022_October;

public class No779_KthGrammar {
    public int kthGrammar(int n, int k) {
        int cnt = 0;
        k--;
        while (k > 0) {
            if (k % 2 == 1) cnt++;
            k /= 2;
        }
        return cnt % 2;
    }
}
