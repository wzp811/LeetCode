package February_2022;

import java.util.LinkedList;
import java.util.List;

public class No1447_SimplifiedFractions {
    public List<String> simplifiedFractions(int n){
        List<String> res = new LinkedList<>();
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(getGCF(i,j)==1) res.add(new String(j+"/"+i));
            }
        }
        return res;
    }
    public int getGCF(int a,int b){
        int bigger = Math.max(a,b);
        int smaller = Math.min(a,b);
        while(bigger%smaller!=0){
            int tmp = smaller;
            smaller = bigger%smaller;
            bigger = tmp;
        }
        return smaller;
    }

    public static void main(String[] args) {
        No1447_SimplifiedFractions obj = new No1447_SimplifiedFractions();
        System.out.println(obj.simplifiedFractions(5));
    }
}
