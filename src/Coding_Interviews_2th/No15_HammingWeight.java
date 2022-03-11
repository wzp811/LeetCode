package Coding_Interviews_2th;

public class No15_HammingWeight {
    public int hammingWeight1(int n){
        int cnt = 0;
        for(int i=0;i<32;i++){
            cnt += (n>>i)&1;
        }
        return cnt;
    }
    public int hammingWeight(int n){
        int cnt = 0;
        while(n!=0){
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
}
