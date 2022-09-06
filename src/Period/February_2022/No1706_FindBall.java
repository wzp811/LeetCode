package Period.February_2022;

import java.util.Arrays;

public class No1706_FindBall {
    final boolean LOWER = false;
    final boolean UPPER = true;
    public int[] findBall(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int row,col;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            row = 0;
            col = i;
            while(row<m){
                int cur = grid[row][col];
                if(cur==1) col++;
                else if(cur==-1) col--;
                if(col==-1||col==n||cur!=grid[row][col]) break;
                row++;
            }
            if(row==m) ans[i] = col;
        }
        return ans;
    }
}
