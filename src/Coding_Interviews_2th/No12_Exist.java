package Coding_Interviews_2th;

public class No12_Exist {
    public boolean exist(char[][] board,String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean cur = board[i][j]==word.charAt(0)&&
                        process(board,word,0,i,j);
                if(cur) return true;
            }
        }
        return false;
    }
    public boolean process(char[][] board,String word,int index,int row,int col){
        if(index==word.length()) return true;
        char tmp = board[row][col];
        board[row][col] = '.';
        if(row-1>=0&&board[row-1][col]==word.charAt(index+1)
                &&process(board,word,index+1,row-1,col)) return true;
        if(row+1<board.length&&board[row+1][col]==word.charAt(index+1)
                &&process(board,word,index+1,row+1,col)) return true;
        if(col-1>=0&&board[row][col-1]==word.charAt(index+1)
                &&process(board,word,index+1,row,col-1)) return true;
        if(col+1<board[0].length&&board[row][col+1]==word.charAt(index+1)
                &&process(board,word,index+1,row,col+1)) return true;
        board[row][col] = tmp;
        return false;
    }
}
