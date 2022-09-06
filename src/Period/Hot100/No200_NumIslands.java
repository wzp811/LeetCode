package Period.Hot100;

public class No200_NumIslands {
    int count = 0;
    public int numIslands(char[][] grid){
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    process(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void process(char[][] grid,int row,int col){
        grid[row][col] = '0';
        if(row-1>=0&&grid[row-1][col]=='1') process(grid,row-1,col);
        if(row+1<grid.length&&grid[row+1][col]=='1') process(grid,row+1,col);
        if(col-1>=0&&grid[row][col-1]=='1') process(grid,row,col-1);
        if(col+1<grid[0].length&&grid[row][col+1]=='1') process(grid,row,col+1);
    }
}
