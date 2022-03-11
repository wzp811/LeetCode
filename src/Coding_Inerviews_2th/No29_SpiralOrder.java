package Coding_Inerviews_2th;

public class No29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix){
        if(matrix.length==0||matrix[0].length==0) return null;
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0, col = 0;
        int[]ans = new int[matrix.length*matrix[0].length];
        int index = 0;
        for(int i=0;i<(Math.min(matrix.length,matrix[0].length)+1)/2;i++){
            row = i;
            col = i;
            for(int j=0;j<4;j++){
                while(row>=i&&row<matrix.length-i&&col>=i&&col<matrix[0].length-i&&index<matrix.length*matrix[0].length){
                    ans[index] = matrix[row][col];
                    row += dir[j][0];
                    col += dir[j][1];
                    index++;
                }
                row -= dir[j][0];
                col -= dir[j][1];
                index--;
            }
        }
        return ans;
    }
}
