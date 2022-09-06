package QuestionList.Coding_Interviews_2th;

public class No14_2_CuttingRope {
    int mod = 1000000007;
    public int cuttingRope(int n){
        return n>=4?(int)process(n):n-1;
    }
    public long process(int n){
        return n>4?(process(n-3)*3%mod):n;
    }
}
