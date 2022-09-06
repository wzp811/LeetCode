package QuestionList.Coding_Interviews_2th;

import java.util.HashSet;
import java.util.Set;

public class No57_TwoSum {
    public int[] twoSum1(int[] nums,int target){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(target-nums[i])) return new int[]{nums[i],target-nums[i]};
            else set.add(nums[i]);
        }
        return new int[0];
    }
    public int[] twoSum(int[] nums,int target){
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target) return new int[]{nums[i],nums[j]};
            else if(nums[i]+nums[j]>target) j--;
            else i++;
        }
        return new int[0];
    }
}
