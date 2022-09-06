package Period.January_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No40_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        combine(candidates,target,0,res,cur);
        return res;
    }
    public void combine(int []candidates,int rest,int index,List<List<Integer>> res,List<Integer> cur){
        if(rest==0){
            List<Integer> tmp = new LinkedList<>(cur);
            if(!res.contains(tmp)) res.add(tmp);
            return;
        }
        if(index==candidates.length) return;
        int size = cur.size();
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]<=rest){
                cur.add(candidates[i]);
                combine(candidates,rest-candidates[i],i+1,res,cur);
                cur.remove(size);
            }
        }
    }

    public static void main(String[] args) {
        No40_combinationSum2 obj = new No40_combinationSum2();
        int[] arr = new int[]{2,5,2,1,2};
        System.out.println(obj.combinationSum2(arr,5));
    }
}
