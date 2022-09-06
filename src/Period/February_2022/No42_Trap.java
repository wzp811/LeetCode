package Period.February_2022;

import java.util.Arrays;
import java.util.Stack;

public class No42_Trap {
    //自己写的单调栈
    public int trap1(int[] height){
        int[] res = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        int highest = 0;
        for(int i=0;i<height.length;i++){
            while(!(stack.isEmpty()||height[stack.peek()]>=height[i])){
                int tmp = stack.pop();
                res[tmp] = highest-height[tmp];
            }
            if(stack.isEmpty()) highest = height[i];
            stack.push(i);
        }
        stack.clear();
        for(int i=height.length-1;i>=0;i--){
            while(!(stack.isEmpty()||height[stack.peek()]>=height[i])){
                int tmp = stack.pop();
                res[tmp] = Math.min(res[tmp],highest-height[tmp]);
            }
            if(stack.isEmpty()) highest = height[i];
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        int count = 0;
        for(int i=0;i<height.length;i++){
            count += res[i];
        }
        return count;
    }
    //自己写的动态规划
    //记录每一列两边的最高点
    public int trap2(int[] height){
        int max = 0;
        int[][] highest = new int[height.length][2];
        for(int i=0;i< height.length;i++){
            highest[i][0] = max;
            max = Math.max(max,height[i]);
        }
        max = 0;
        int count = 0;
        for(int i=height.length-1;i>=0;i--){
            highest[i][1] = max;
            count += Math.max(Math.min(highest[i][0],highest[i][1])-height[i],0);
            max = Math.max(max,height[i]);
        }
        return count;
    }
    //一次遍历的单调栈
    public int trap(int[] height){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!(stack.isEmpty()||height[stack.peek()]>height[i])){
                int center = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                count += (Math.min(height[left],height[i])-height[center])*(i-left-1);
            }
            stack.push(i);
        }
        return count;
    }

    public static void main(String[] args) {
        No42_Trap obj = new No42_Trap();
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(obj.trap(height));
    }
}
