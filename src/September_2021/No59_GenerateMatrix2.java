package September_2021;
import java.util.*;

public class No59_GenerateMatrix2 {
    public static void main(String[] args) {
        No59_GenerateMatrix2 ex = new No59_GenerateMatrix2();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [][]res = ex.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int [][] generateMatrix(int n){
        int num = 1;
        int i,j;
        int layer = 0;
        int [][]res = new int [n][n];
        while(layer<n/2){
            i = layer;
            j = layer;
            for(j=layer;j<n-layer-1;j++){
                res[i][j] = num++;
            }
            for(i=layer;i<n-layer-1;i++){
                res[i][j] = num++;
            }
            for(j=n-layer-1;j>layer;j--){
                res[i][j] = num++;
            }
            for(i=n-layer-1;i>layer;i--){
                res[i][j] = num++;
            }
            layer++;
        }
        if(n%2!=0){
            res[n/2][n/2] = num;
        }
        return res;
    }
}
