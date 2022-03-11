package January_2022;

import java.util.LinkedList;
import java.util.List;

public class No78_Subsets {
    public List<List<Integer>> subsets(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        calc(nums,0,res,cur);
        return res;
    }
    public void calc(int[] nums,int index,List<List<Integer>> res,List<Integer> cur){
        List<Integer> tmp = new LinkedList<>(cur);
        res.add(tmp);
        int size = cur.size();
        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            calc(nums,i+1,res,cur);
            cur.remove(size);
        }
    }

    public static void main(String[] args) {
        No78_Subsets obj = new No78_Subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(obj.subsets(nums));
    }
}
