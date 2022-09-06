package Period.Hot100;

public class No240_SearchMatrix {
    public boolean searchMatrix1(int[][] matrix,int target){
        int row = 0, col = 0;
        int lastR = 0, lastC = 0;
        while(row<matrix.length&&col<matrix[0].length){
            if(target==matrix[row][col]){
                return true;
            }else if(target>matrix[row][col]){
                row++;
                col++;
                if(row==matrix.length) {
                    lastC = col+1;
                    row = lastR;
                }
                if(col==matrix[0].length) {
                    lastR = row+1;
                    col = lastC;
                }
            }else{
                break;
            }
        }
        if(row==matrix.length||col==matrix[0].length) return false;
        for(int i=lastR;i<=row;i++) if(target==matrix[i][col]) return true;
        for(int i=lastC;i<=col;i++) if(target==matrix[row][i]) return true;
        return false;




    }


//从左下角开始，左下角是当前行最小，当前列最大。然后根据情况上移或者右移，能找到
    public boolean searchMatrix2(int[][] matrix,int target){
        int row = matrix.length-1;
        int col = 0;
        while(row>=0&&col<matrix[0].length){
            if(target>matrix[row][col]){
                row--;
            }else if(target<matrix[row][col]){
                col++;
            }else{
                return true;
            }
        }
        return false;
    }

//    对每一行二分法
    public boolean searchMatrix(int[][] matrix,int target){
        for(int i=0;i<matrix.length;i++){
            int l = 0, r = matrix[0].length-1;
            int mid = (l+r)/2;
            while(l<r){
                if(target==matrix[i][mid]) return true;
                else if(target>matrix[i][mid]) l = mid+1;
                else if(target<matrix[i][mid]) r = mid;
            }
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix,int target){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            if(target>matrix[row][col]){
                row++;
            }else if(target<matrix[row][col]){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }
}
