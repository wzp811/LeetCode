package February_2022;

import java.util.Arrays;

public class No2006_CountKDifference {
    public int countKDifference(int[] nums,int k){
        Arrays.sort(nums);
        if(nums.length<2||nums[nums.length-1]<k) return 0;
        int[] cnt = new int[nums[nums.length-1]];
        for(int i=0;i<nums.length;i++) cnt[nums[i]]++;
        int count = 0;
        int i = 0;
        int j = i+k;
        while(j<cnt.length){
            count += cnt[i]*cnt[j];
            i++;
            j++;
        }
        return count;
    }
}
