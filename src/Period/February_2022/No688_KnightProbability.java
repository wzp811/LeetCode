package Period.February_2022;

import java.util.Arrays;

public class No688_KnightProbability {
    public double knightProbability1(int n, int k, int row, int column){
        if(k==0) return 1;
        double res = 0;
        if(row+1<n&&column+2<n) res += knightProbability1(n,k-1,row+1,column+2);
        if(row+1<n&&column-2>=0) res += knightProbability1(n,k-1,row+1,column-2);
        if(row-1>=0&&column+2<n) res += knightProbability1(n,k-1,row-1,column+2);
        if(row-1>=0&&column-2>=0) res += knightProbability1(n,k-1,row-1,column-2);
        if(row+2<n&&column+1<n) res += knightProbability1(n,k-1,row+2,column+1);
        if(row+2<n&&column-1>=0) res += knightProbability1(n,k-1,row+2,column-1);
        if(row-2>=0&&column+1<n) res += knightProbability1(n,k-1,row-2,column+1);
        if(row-2>=0&&column-1>=0) res += knightProbability1(n,k-1,row-2,column-1);
        return res/8;
    }
    public double knightProbability2(int n,int k,int row,int column){
        int[][][]dp = new int[k+1][n][n];
        dp[0][row][column] = 1;
        for(int p=1;p<=k;p++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i+1<n&&j+2<n) dp[p][i][j] += dp[p-1][i+1][j+2];
                    if(i+1<n&&j-2>=0) dp[p][i][j] += dp[p-1][i+1][j-2];
                    if(i-1>=0&&j+2<n) dp[p][i][j] += dp[p-1][i-1][j+2];
                    if(i-1>=0&&j-2>=0) dp[p][i][j] += dp[p-1][i-1][j-2];
                    if(i+2<n&&j+1<n) dp[p][i][j] += dp[p-1][i+2][j+1];
                    if(i+2<n&&j-1>=0) dp[p][i][j] += dp[p-1][i+2][j-1];
                    if(i-2>=0&&j+1<n) dp[p][i][j] += dp[p-1][i-2][j+1];
                    if(i-2>=0&&j-1>=0) dp[p][i][j] += dp[p-1][i-2][j-1];
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res += dp[k][i][j];
            }
        }
        return (double)(res/Math.pow(8,k));
    }

    public double knightProbability(int n,int k,int row,int column){
        int[][] dir = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        double[][][] dp = new double[k+1][n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[0][i],1);
        for(int p=1;p<=k;p++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int t=0;t<8;t++){
                        int nx = i+dir[t][0],ny = j+dir[t][1];
                        if(nx>=0&&nx<n&&ny>=0&&ny<n) dp[p][i][j] += dp[p-1][nx][ny]/8;
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        No688_KnightProbability obj = new No688_KnightProbability();
        System.out.println(obj.knightProbability(3,2,0,0));
    }
}
