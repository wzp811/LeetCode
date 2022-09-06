package Period.Hot100;

import java.util.Arrays;

public class No238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int prev = 1;
        for(int i=1;i<nums.length;i++){
            prev = prev*nums[nums.length-1-i];
            ans[nums.length-1-i] *= prev;
        }
        return ans;
    }
}
