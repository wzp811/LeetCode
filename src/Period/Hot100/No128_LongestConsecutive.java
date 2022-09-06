package Period.Hot100;

import java.util.HashSet;

public class No128_LongestConsecutive {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxlen = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                int r = nums[i]+1;
                while(set.contains(r)) set.remove(r++);
                int l = nums[i]-1;
                while(set.contains(l)) set.remove(l--);
                maxlen = Math.max(maxlen,r-l-1);
            }
        }
        return maxlen;
    }
}
