package _HashMap;

import java.util.*;

public class No15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right]+nums[i];
                if(sum==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    tmp.add(nums[i]);
                    ans.add(tmp);

                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;

                }else if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }
            }
        }
        return ans;
    }
}
