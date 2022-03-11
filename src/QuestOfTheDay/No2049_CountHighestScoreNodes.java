package QuestOfTheDay;

import java.util.HashMap;
import java.util.Map;

public class No2049_CountHighestScoreNodes {
    int[][] children;
    long len;
    int cnt = 0;
    long max = 0;
    public int countHighestScoreNodes(int[] parents){
        len = parents.length;
        children = new int[parents.length][2];
        for(int i=0;i<parents.length;i++){
            children[i][0] = -1;
            children[i][1] = -1;
        }
        for(int i=1;i<parents.length;i++){
            if(children[parents[i]][0]==-1){
                children[parents[i]][0] = i;
            }else{
                children[parents[i]][1] = i;
            }
        }
        process(0);
        return cnt;
    }
    public long process(int root){
        long left = 0, right = 0;
        if(children[root][0]!=-1) left = process(children[root][0]);
        if(children[root][1]!=-1) right = process(children[root][1]);
        long curAns = Math.max(left,1)*Math.max(right,1)*Math.max((len-left-right-1),1);
        if(curAns==max){
            cnt++;
        }else if(curAns>max){
            max = curAns;
            cnt = 1;
        }
        return left+right+1;
    }
}
