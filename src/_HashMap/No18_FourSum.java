package _HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18_FourSum {
    public List<List<Integer>> fourSUm(int[] nums,int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4) return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>1&&nums[j]==nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        ans.add(cur);

                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;

                    }else if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }
                }
            }
        }
        return ans;
    }

}
