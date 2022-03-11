package January_2022;

public class No2045_SecondMinimum {
    public int secondMinimum(int n,int [][]edges,int time,int change){
        int [][]node = new int[n][n];
        for(int i=0;i<edges.length;i++){
            node[edges[i][0]][edges[i][1]] = 1;
            node[edges[i][1]][edges[i][0]] = 1;
        }
        return 0;
    }
}
