package February_2022;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class No2104_SubArrayRanges {
    // 暴力O(n2)
    public long subArrayRanges1(int[] nums){
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            int max = nums[i];
            int min = nums[i];
            for(int j=i+1;j<nums.length;j++){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                ans += (long)(max-min);
            }
        }
        return ans;
    }
    // O(N)
    public long subArrayRanges(int[] nums){
        long ans = 0;
        long[] max = getCnt(nums,true);
        long[] min = getCnt(nums,false);
        for(int i=0;i<nums.length;i++) ans += nums[i]*(max[i]-min[i]);
        return ans;
    }
    public long[] getCnt(int[]nums,boolean isGreater){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,nums.length);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()||
                    (isGreater?nums[stack.peek()]>=nums[i]:nums[stack.peek()]<=nums[i]))){
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!(stack.isEmpty()||
                    (isGreater?nums[stack.peek()]>nums[i]:nums[stack.peek()]<nums[i]))){
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        long[] res = new long[nums.length];
        for(int i=0;i<nums.length;i++) res[i] = (long)((right[i]-i)*(i-left[i]));
        System.out.println(Arrays.toString(res));
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        No2104_SubArrayRanges obj = new No2104_SubArrayRanges();
        int[] nums = new int[]{1,2,3};
        System.out.println(obj.subArrayRanges(nums));
    }
}
