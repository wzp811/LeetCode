package Coding_Inerviews_2th;

import java.util.Arrays;

public class No61_IsStraight {
    public boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int index = 0;
        while(nums[index]==0&&index<nums.length) {
            index++;
        }
        for(int i=index+1;i<nums.length;i++){
            index -= nums[i]-nums[i-1]-1;
            if(index<0||nums[i]==nums[i-1]) return false;
        }
        return true;
    }
}
