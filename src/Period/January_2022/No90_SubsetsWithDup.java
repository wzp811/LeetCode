package Period.January_2022;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No90_SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        calc(nums,0,res,cur);
        return res;
    }
    public void calc(int[] nums,int index,List<List<Integer>> res,List<Integer> cur){
        List<Integer> tmp = new LinkedList<>(cur);
        if(!res.contains(tmp)) res.add(tmp);
        int size = cur.size();
        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            calc(nums,i+1,res,cur);
            cur.remove(size);
        }
    }
    public static void main(String[] args) {
        No90_SubsetsWithDup obj = new No90_SubsetsWithDup();
        int[] nums = new int[]{1,2,2};
        System.out.println(obj.subsetsWithDup(nums));
    }

}
