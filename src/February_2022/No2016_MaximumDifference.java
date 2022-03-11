package February_2022;

import java.util.Stack;

public class No2016_MaximumDifference {
    public int maximumDifference1(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int min = nums[0];
        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()||stack.peek()<nums[i])){
                stack.pop();
            }
            if(stack.isEmpty()) min = nums[i];
            stack.push(nums[i]);
        }
        return stack.peek()==min?-1:stack.peek()-min;
    }
    public int maximumDifference(int[] nums){
        int min = nums[0];
        int max = -1;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            if(nums[i]>min) max = Math.max(max,nums[i]-min);
        }
        return max;
    }
}
