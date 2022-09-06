package Period.January_2022;

import java.util.Arrays;

public class No37_SolveSudoku {
    public void solveSudoku(char[][] board){
        int[] count = new int[10];
        Arrays.fill(count,0);
        int[][] help = new int[10][9];
        for(int i=0;i<10;i++){
            Arrays.fill(help[i],-1);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j] - '0';
                    help[num][count[num]] = i*9+j;
//                    System.out.println("num: "+num+"\tcount["+num+"]: "+count[num]+"\thelp[num][count]: "+help[num][count[num]]);
                    count[num]++;
                }
            }
        }
        process(board,count,help,0);
    }
    public boolean process(char[][] board,int[] count,int [][]help,int index){
        int row = index/9;
        int col = index%9;
        if(index>=81) return true;
//        System.out.println("board: "+board[row][col]);
        if(board[row][col]!='.') return process(board,count,help,index+1);
        for(int i=1;i<=9;i++){
//            System.out.println("\tindex: "+index+"\ti: "+i+"\tcount["+i+"]: "+count[i]);
            boolean flag = true;
            for(int j=0;j<count[i];j++){
                if(count[i]==9||(help[i][j]/9==index/9)||(help[i][j]%9==index%9)||(help[i][j]/9/3==index/9/3&&help[i][j]%9/3==index%9/3)){
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            board[row][col] = (char)(i+'0');
            help[i][count[i]] = index;
            count[i]++;
            if(process(board,count,help,index+1)) return true;
            count[i]--;
        }
        board[row][col] = '.';
        return false;
    }

    public static void main(String[] args) {
        No37_SolveSudoku obj = new No37_SolveSudoku();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
//        char[][] board = new char[][]{
//                {'5','3','4','6','7','8','9','1','2'},
//                {'6','7','2','1','9','5','3','4','8'},
//                {'1','9','8','3','4','2','5','6','7'},
//                {'8','5','9','.','6','1','4','2','3'},
//                {'4','2','6','8','5','3','7','9','1'},
//                {'7','1','3','9','2','4','8','5','6'},
//                {'9','6','1','5','3','7','2','8','4'},
//                {'2','8','7','4','1','9','6','3','5'},
//                {'3','4','5','2','8','6','1','7','9'}
//        };
        obj.solveSudoku(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
