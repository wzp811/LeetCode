package Period.Hot100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No448_FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        for(int i=1;i<=nums.length;i++) set.add(i);
        for(int i=0;i< nums.length;i++) if(set.contains(nums[i])) set.remove(nums[i]);
        for(int i:set){
            res.add(i);
        }
        return res;
    }

//    修改原数组，用来充当set的作用
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> ans = new LinkedList<>();
        int n = nums.length;
//        对于每个存在的，其值加上n，那么在遍历一次如果大于n就说明存在
        for(int i=0;i<nums.length;i++) nums[(nums[i]-1)%n] += n;

        for(int i=0;i<nums.length;i++) if(nums[i]<=n) ans.add(nums[i]);
        return ans;
    }
}
