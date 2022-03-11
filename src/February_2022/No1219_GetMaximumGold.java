package February_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No1219_GetMaximumGold {
    public int getMaximumGold(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) Arrays.fill(visited[i],false);
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0) {
                    int count = 0;
                    if (i > 0 && grid[i - 1][j] != 0) count++;
                    if (i < grid.length - 1 && grid[i + 1][j] != 0) count++;
                    if (j > 0 && grid[i][j - 1] != 0) count++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] != 0) count++;
                    if(count<=2) process(grid, visited, i, j, 0, res);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<res.size();i++){
            if(res.get(i)>max) max = res.get(i);
        }
        System.out.println(res);
        return max;
    }
    public void process(int[][] grid,boolean[][] visited,int row,int col,int cur,List<Integer> res){
        int count = 0;
        int tmp = grid[row][col];
        visited[row][col] = true;
        cur += tmp;
        if(row>0&&!visited[row-1][col]&&grid[row-1][col]!=0) {
            process(grid, visited, row - 1, col, cur,res);
            count++;
        }
        if(row<grid.length-1&&!visited[row+1][col]&&grid[row+1][col]!=0) {
            process(grid, visited, row + 1, col, cur,res);
            count++;
        }
        if(col>0&&!visited[row][col-1]&&grid[row][col-1]!=0) {
            process(grid, visited, row, col - 1, cur,res);
            count++;
        }
        if(col<grid[0].length-1&&!visited[row][col+1]&&grid[row][col+1]!=0) {
            process(grid, visited, row, col + 1, cur,res);
            count++;
        }
        visited[row][col] = false;
        if(count==0){
            res.add(cur);
        }
    }

    public static void main(String[] args) {
        No1219_GetMaximumGold obj = new No1219_GetMaximumGold();
//        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int[][] grid = new int[][]{{0,0,1}, {1,1,0}, {1,1,0}};
//        int[][] grid = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(obj.getMaximumGold(grid));
    }
}
