package February_2022;

import java.util.Arrays;
import java.util.Stack;

public class No84_LargestRectangleArea {
    public int largestRectangleArea1(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[][] lower = new int[2][heights.length];
        Arrays.fill(lower[1],-1);
        Arrays.fill(lower[0],heights.length);
        for(int i=0;i<heights.length;i++){
            while(!(stack.isEmpty()||heights[stack.peek()]<=heights[i])){
                int index = stack.pop();
                lower[0][index] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i= heights.length-1;i>=0;i--){
            while(!(stack.isEmpty()||heights[stack.peek()]<=heights[i])){
                int index = stack.pop();
                lower[1][index] = i;
            }
            stack.push(i);
        }
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max(max,heights[i]*(lower[0][i]-lower[1][i]-1));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[][] lower = new int[2][heights.length];
        for(int i=0;i<heights.length;i++){
            while(!(stack.isEmpty()||heights[stack.peek()]<heights[i])){
                int tmp = stack.pop();
                lower[1][tmp] = i;
            }
            lower[0][i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty()) lower[1][stack.pop()] = heights.length;
        int max = 0;
        for(int i=0;i<heights.length;i++) System.out.print(lower[0][i]+" ");
        System.out.println();
        for(int i=0;i<heights.length;i++) System.out.print(lower[1][i]+" ");
        System.out.println();

        for(int i=0;i<heights.length;i++) max = Math.max(max,heights[i]*(lower[1][i]-lower[0][i]-1));
        return max;
    }

    public static void main(String[] args) {
        No84_LargestRectangleArea obj = new No84_LargestRectangleArea();
//        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights = new int[]{2,4};
        System.out.println(obj.largestRectangleArea(heights));
    }
}
