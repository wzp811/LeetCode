package February_2022;

import java.util.LinkedList;
import java.util.List;

public class No1380_LuckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix){
        List<Integer> res = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            int index = 0;
            for(int j=0;j<col;j++){
                if(matrix[i][j]<matrix[i][index]) index = j;
            }
            boolean flag = true;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][index]>matrix[i][index]){
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(matrix[i][index]);
        }
        return res;
    }

    public static void main(String[] args) {
        No1380_LuckyNumbers obj = new No1380_LuckyNumbers();
//        int[][] matrix = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
//        int[][] matrix = new int[][]{{1,10,4,2}, {9,3,8,7}, {15, 16, 17,12}};
        int[][] matrix = new int[][]{{7,8},{1,2}};
        System.out.println(obj.luckyNumbers(matrix));
    }
}
