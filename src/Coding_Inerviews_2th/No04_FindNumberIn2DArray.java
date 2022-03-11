package Coding_Inerviews_2th;

public class No04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray1(int[][] matrix,int target){
        int row = matrix.length-1;
        int col = 0;
        while(row>=0&&col<matrix[0].length){
            if(target==matrix[row][col]) return true;
            if(target>matrix[row][col]) col++;
            else row--;
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix,int target){
        if(matrix.length==0) return false;
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            if(target==matrix[row][col]) return true;
            if(target>matrix[row][col]) row++;
            else col--;
        }
        return false;
    }
}
