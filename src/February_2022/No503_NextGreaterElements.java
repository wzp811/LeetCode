package February_2022;

import java.util.Arrays;
import java.util.Stack;

public class No503_NextGreaterElements {
    public int[] nextGreaterElements(int[] nums){
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()||nums[stack.peek()]>=nums[i])){
                int tmp = stack.pop();
                res[tmp] = nums[i];
            }
            stack.push(i);
        }
        if(stack.isEmpty()) return res;
        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()||nums[stack.peek()]>=nums[i])){
                int tmp = stack.pop();
                res[tmp] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        No503_NextGreaterElements obj = new No503_NextGreaterElements();
//        int[] nums = new int[]{1,2,1};
        int[] nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(obj.nextGreaterElements(nums)));
    }
}
