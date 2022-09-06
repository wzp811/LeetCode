package Period.January_2022;

import java.util.*;
//列情况
//1.k<=0  直接返回false
//2.k>=nums.length    可能有重复，可能没重复
//2.k>0 k<nums.length 正常判断


public class No219_ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) s.remove(nums[i-k-1]);
            if(s.contains(nums[i])) return true;
            s.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = new int[4];
        nums[0] = 1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;
        No219_ContainsNearbyDuplicate obj = new No219_ContainsNearbyDuplicate();
        System.out.println(obj.containsNearbyDuplicate(nums,1));
    }
}
