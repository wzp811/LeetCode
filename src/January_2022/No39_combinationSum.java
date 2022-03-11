package January_2022;

import java.util.LinkedList;
import java.util.List;

public class No39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        combine(candidates,target,0,res,cur);
        return res;
    }
    public void combine(int[] candidates,int rest,int index,List<List<Integer>> res,List<Integer> cur){
        if(rest==0){
            List<Integer> cpy = new LinkedList<>(cur);
            res.add(cpy);
            return;
        }else if(index==candidates.length){
            return;
        }
        int size = cur.size();
        int num = candidates[index];
        for(int i=0;i<=rest/num;i++){
            combine(candidates,rest-i*num,index+1,res,cur);
            cur.add(num);
        }
        while(cur.size()>size){
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        No39_combinationSum obj = new No39_combinationSum();
        int[] arr = new int[]{2,3,6,7};
        System.out.println(obj.combinationSum(arr,7));
    }
}
