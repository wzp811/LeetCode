package Hot100;

public class No48_Rotate {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        No48_Rotate obj = new No48_Rotate();
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix = new int[][]{{1}};
        obj.rotate(matrix);
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
