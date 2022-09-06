package Period.January_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NO1765_HIghesPeak {
    public int[][] highesPeak(int [][] isWater){
        int row = isWater.length;
        int col = isWater[0].length;
        int [][] high = new int[row][col];
        for(int i=0;i<row;i++) Arrays.fill(high[i],-1);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isWater[i][j]==1){
                    queue.add(i*col+j);
                    high[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            int index = queue.poll();
            int i = index/col;
            int j = index%col;
            int highCur = high[i][j];
            if(i-1>=0&&high[i-1][j]==-1){
                queue.add((i-1)*col+j);
                high[i-1][j] = highCur+1;
            }
            if(i+1<row&&high[i+1][j]==-1){
                queue.add((i+1)*col+j);
                high[i+1][j] = highCur+1;
            }
            if(j-1>=0&&high[i][j-1]==-1){
                queue.add(i*col+j-1);
                high[i][j-1] = highCur+1;
            }
            if(j+1<col&&high[i][j+1]==-1){
                queue.add(i*col+j+1);
                high[i][j+1] = highCur+1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        NO1765_HIghesPeak obj = new NO1765_HIghesPeak();
        int [][] isWater = new int[][]{{1,2,3},{4,5,6}};
        int [][] tmp = new int[2][3];
        Arrays.fill(tmp[0],-1);
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[0].length;j++){
                System.out.println(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(isWater.length);
        System.out.println(isWater[0].length);
    }
}
