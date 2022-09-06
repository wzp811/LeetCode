package Tags._Arrays;

public class No59_GenerateMatrix {
    public int[][] generateMatrix(int n){
        int index = 1;
        int[][] ans = new int[n][n];
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i;j++){
                ans[i][j] = index++;
            }
            for(int j=i+1;j<n-i;j++){
                ans[j][n-i-1] = index++;
            }
            for(int j=n-i-2;j>i;j--){
                ans[n-i-1][j] = index++;
            }
            for(int j=n-i-2;j>i;j--){
                ans[j][i] = index++;
            }
        }
        if(n%2==1) ans[n/2][n/2] = index;
        return ans;
    }
}
