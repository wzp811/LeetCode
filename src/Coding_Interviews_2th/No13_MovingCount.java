package Coding_Interviews_2th;

public class No13_MovingCount {
    int count = 0;
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int movingCount(int m,int n,int k){
        boolean[][] visited = new boolean[m][n];
        process(visited,m,n,k,0,0);
        return count;
    }
    public void process(boolean[][] visited,int m,int n,int k,int row,int col){
        visited[row][col] = true;
        System.out.println(row+" "+col);
        count++;
        for(int i=0;i<4;i++){
            if(row+dir[i][0]>=0&&row+dir[i][0]<m&&col+dir[i][1]>=0&&col+dir[i][1]<n
                    &&!visited[row+dir[i][0]][col+dir[i][1]]
                    &&(row+dir[i][0])%10+(row+dir[i][0])/10+(col+dir[i][1])%10+(col+dir[i][1])/10<=k)
                process(visited,m,n,k,row+dir[i][0],col+dir[i][1]);
        }
        return;
    }
}
