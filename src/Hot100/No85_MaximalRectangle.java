package Hot100;

import java.util.Arrays;
import java.util.Stack;

public class No85_MaximalRectangle {
    public int maximalRectangle1(int[][] matrix){
        if(matrix.length==0) return 0;
        int [][]height = new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            int h = 0;
            for(int i=matrix.length-1;i>=0;i--){
                if(matrix[i][j]==1) h++;
                else h = 0;
                height[i][j] = h;
            }
        }
        System.out.println("height");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) System.out.print(height[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        int[][][] lower = new int[matrix.length][matrix[0].length][2];
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            stack.clear();
            for(int j=0;j<matrix[0].length;j++){
                while(!(stack.isEmpty()||height[i][stack.peek()]<height[i][j])){
                    int cur = stack.pop();
                    lower[i][cur][1] = j;
                    max = Math.max(max,(lower[i][cur][1]-lower[i][cur][0]-1)*height[i][cur]);
                }
                lower[i][j][0] = stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            while(!stack.isEmpty()) {
                int cur = stack.pop();
                lower[i][cur][1] = matrix[0].length;
                max = Math.max(max,(lower[i][cur][1]-lower[i][cur][0]-1)*height[i][cur]);
            }
        }
        System.out.println("left");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) System.out.print(lower[i][j][0]+" ");
            System.out.println();
        }
        System.out.println();
        System.out.println("right");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) System.out.print(lower[i][j][1]+" ");
            System.out.println();
        }
        System.out.println();
        return max;
    }

    public int maximalRectangle(int[][] matrix){
        if(matrix.length==0) return 0;
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0) height[i][j] = matrix[i][j]==1?1:0;
                else height[i][j] = matrix[i][j]==1?height[i-1][j]+1:0;
            }
        }
        System.out.println("height");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) System.out.print(height[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(height[i][j]*matrix[0].length>=max){
                    int cur = j;
                    int len = 0;
                    while(cur>=0&&height[i][cur--]>=height[i][j]) len++;
                    cur = j+1;
                    while(cur<matrix[0].length&&height[i][cur++]>=height[i][j]) len++;
                    max = Math.max(max,len*height[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No85_MaximalRectangle obj = new No85_MaximalRectangle();
//        int[][] matrix = new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int[][] matrix = new int[][]{{0,0,1},{1,1,1}};
//        int[][] matrix = new int[][]{};
        System.out.println(obj.maximalRectangle(matrix));
    }
}
