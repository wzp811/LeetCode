package Period.January_2022;

import java.util.LinkedList;
import java.util.List;

public class No77_Combine {
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        combine(0,n,k,res,cur);
        return res;
    }
    public void combine(int L,int R,int rest,List<List<Integer>> res,List<Integer> cur){
        if(R-L+1<=rest) return;
        if(rest==0){
            List<Integer> cpy = new LinkedList<>(cur);
            res.add(cpy);
            return;
        }
        for(int i=L;i<=R-rest+1;i++){
            int size = cur.size();
            cur.add(i+1);
            combine(i+1,R,rest-1,res,cur);
            cur.remove(size);
        }
    }

    public static void main(String[] args) {
        No77_Combine obj = new No77_Combine();
        List<List<Integer>> res = obj.combine(4,2);
        System.out.println(res);
    }
}
