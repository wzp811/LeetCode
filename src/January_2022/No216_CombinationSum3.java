package January_2022;

import java.util.LinkedList;
import java.util.List;

public class No216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        calc(k,n,1,res,cur);
        return res;
    }
    public void calc(int k,int n,int L,List<List<Integer>> res,List<Integer> cur){
        if(k*n==0&&k+n!=0) return;
        if(n==0&&k==0){
            List<Integer> cpy = new LinkedList<>(cur);
            res.add(cpy);
            return;
        }
        int size = cur.size();
        for(int i=L;i<=Math.min(9,n);i++){
            cur.add(i);
            calc(k-1,n-i,i+1,res,cur);
            cur.remove(size);
        }
    }

    public static void main(String[] args) {
        No216_CombinationSum3 obj = new No216_CombinationSum3();
        System.out.println(obj.combinationSum3(3,9));
    }
}
