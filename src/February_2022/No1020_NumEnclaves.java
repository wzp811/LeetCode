package February_2022;

import java.util.Arrays;

public class No1020_NumEnclaves {
    boolean[][] visited;
    int count = 0;
    public int numEnclaves(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int numOfOne = 0;
        for(int i=0;i<row;i++) Arrays.fill(visited[i],false);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) numOfOne += grid[i][j];
            if(grid[i][0]==1&&!visited[i][0]) travel(grid,i,0);
            if(grid[i][col-1]==1&&!visited[i][col-1]) travel(grid,i,col-1);
        }
        for(int i=0;i<col;i++){
            if(grid[0][i]==1&&!visited[0][i]) travel(grid,0,i);
            if(grid[row-1][i]==1&&!visited[row-1][i]) travel(grid,row-1,i);
        }
        return numOfOne-count;
    }
    public void travel(int[][] grid,int x,int y){
        visited[x][y] = true;
        count++;
        if(x>0&&grid[x-1][y]==1&&!visited[x-1][y]) travel(grid,x-1,y);
        if(x<grid.length-1&&grid[x+1][y]==1&&!visited[x+1][y]) travel(grid,x+1,y);
        if(y>0&&grid[x][y-1]==1&&!visited[x][y-1]) travel(grid,x,y-1);
        if(y<grid[0].length-1&&grid[x][y+1]==1&&!visited[x][y+1]) travel(grid,x,y+1);
    }

    public static void main(String[] args) {
        No1020_NumEnclaves obj = new No1020_NumEnclaves();
        int[][]grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println( obj.numEnclaves(grid));
    }
}
