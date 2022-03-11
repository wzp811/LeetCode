package January_2022;

import java.util.HashMap;
import java.util.Map;

public class No2013_DetectSquares {
    HashMap<Integer,HashMap<Integer,Integer>> pointCount;
    public No2013_DetectSquares(){
        pointCount = new HashMap<>();
    }
    public void add(int[] point){
        HashMap<Integer,Integer> tmp = pointCount.getOrDefault(point[0],new HashMap<>());
        int oldCount = tmp.getOrDefault(point[1],new Integer(0));
        tmp.put(point[1],oldCount+1);
        pointCount.put(point[0],tmp);
    }
    public int count(int[] point){
        if(!pointCount.containsKey(point[0])) return 0;
        int res = 0;
        HashMap<Integer,Integer> thisCol = pointCount.get(point[0]);
        for(Map.Entry<Integer,Integer> entry: thisCol.entrySet()){
            int y = entry.getKey();
            if(y==point[1]) continue;
            int p1count = entry.getValue();
            if(pointCount.containsKey(point[0]-Math.abs(y-point[1]))){
                HashMap<Integer,Integer> left = pointCount.get(point[0]-Math.abs(y-point[1]));
                int p2count = left.getOrDefault(point[1],new Integer(0));
                int p3count = left.getOrDefault(y,new Integer(0));
                res += p1count*p2count*p3count;
            }
            if(pointCount.containsKey(point[0]+Math.abs(y-point[1]))){
                HashMap<Integer,Integer> right = pointCount.get(point[0]+Math.abs(y-point[1]));
                int p2count = right.getOrDefault(point[1],new Integer(0));
                int p3count = right.getOrDefault(y,new Integer(0));
                res += p1count*p2count*p3count;
            }
        }
        return res;
    }
}
