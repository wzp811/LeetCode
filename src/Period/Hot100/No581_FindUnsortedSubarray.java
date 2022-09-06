package Period.Hot100;

import java.util.Stack;

public class No581_FindUnsortedSubarray {
    // 自己写的单调栈
    public int findUnsortedSubarray1(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int min = nums.length-1;
        for(int i=0;i<nums.length;i++){
            while(!(stack.isEmpty()||nums[stack.peek()]<=nums[i])){
                min = Math.min(min,stack.pop());
            }
            stack.push(i);
        }
        int max = 0;
        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!(stack.isEmpty()||nums[stack.peek()]>=nums[i])){
                max = Math.max(max,stack.pop());
            }
            stack.push(i);
        }
        return max<=min?0:max-min+1;
    }
//    从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束
//    记录需要调整的最大位置 i 为 high
//    同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束
//    记录需要调整的最小位置 i 为 low.
    public int findUnsortedSubarray(int[] nums){
        int max = nums[0];
        int high = 0, low = 0;
        for(int i=0;i<nums.length;i++){
            if(max>nums[i]) high = i;
            max = Math.max(max,nums[i]);
        }
        int min = nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            if(min<nums[i]) low = i;
            min = Math.min(min,nums[i]);
        }
        return high==low?0:high-low+1;
    }

    public static void main(String[] args) {
        No581_FindUnsortedSubarray obj = new No581_FindUnsortedSubarray();
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(obj.findUnsortedSubarray(nums));
    }
}
