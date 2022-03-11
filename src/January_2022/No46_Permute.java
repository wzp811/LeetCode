package January_2022;

import java.util.LinkedList;
import java.util.List;

public class No46_Permute {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(nums,0,res,cur);
        return res;
    }
    public void process(int[] nums,int index,List<List<Integer>> res,List<Integer> cur){
        if(index==nums.length){
            res.add(new LinkedList<>(cur));
            return;
        }
        int size = cur.size();
        for(int i=0;i<nums.length;i++){
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                process(nums,index+1,res,cur);
                cur.remove(size);
            }
        }
    }
}
