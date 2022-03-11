package Coding_Inerviews_2th;

public class No17_PrintNumbers {
    public int[] printNumbers(int n){
        int ncpy = n;
        int len = 1;
        int cur = 10;
        while(ncpy!=0){
            len *= (ncpy&1)==0?1:cur;
            cur *= cur;
            ncpy >>= 1;
        }
        len -= 1;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = i+1;
        }
        return res;
    }
}
