package Tags._HashMap;

import java.util.HashSet;
import java.util.Set;

public class No202_IsHappy {
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int ans = 0;
            while(n>0){
                ans += (n%10)*(n%10);
                n /= 10;
            }
            n = ans;
            if(n==1) return true;
        }
        return false;
    }
}
