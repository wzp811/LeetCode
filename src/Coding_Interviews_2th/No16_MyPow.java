package Coding_Interviews_2th;

public class No16_MyPow {
    public double myPow(double x,int n){
        if(x==1||x==0) return x;
        double ans = 1.0;
        long ncpy = n;
        if(ncpy<0){
            x = 1/x;
            ncpy = -ncpy;
        }
        while(ncpy!=0){
            ans *= (ncpy&1)==0?1:x;
            if(ans==0) return ans;
            x *= x;
            ncpy >>= 1;
        }
        return ans;
    }
}
