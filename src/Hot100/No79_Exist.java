package Hot100;

import java.util.Arrays;

public class No79_Exist {
    int[][]dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public boolean exist(char[][]board,String word){
        System.out.println(word.substring(1));
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) Arrays.fill(visited[i],false);
        boolean res = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    visited[i][j] = true;
                    res = res||travel(board,visited,word.substring(1),i,j);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }
    public boolean travel(char[][]board,boolean[][]visited,String word,int row,int col){
        if(word.length()==0) return true;
        boolean res = false;
        for(int i=0;i<4;i++){
            if (row+dir[i][0]>=0&&row+dir[i][0]<board.length&&col+dir[i][1]>=0&&col+dir[i][1]<board[0].length&&
                    !visited[row+dir[i][0]][col+dir[i][1]]&&board[row+dir[i][0]][col+dir[i][1]]==word.charAt(0)){
                visited[row+dir[i][0]][col+dir[i][1]] = true;
                res = res||travel(board,visited,word.substring(1),row+dir[i][0],col+dir[i][1]);
                visited[row+dir[i][0]][col+dir[i][1]] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No79_Exist obj = new No79_Exist();
    }
}
