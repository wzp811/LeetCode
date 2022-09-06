package Period.January_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No539_FindMinDifference {
    public int findMinDifference(List<String> timePoints){
        String[]help = new String[timePoints.size()];
        int[]count = new int [10];
        for(int d=4;d>=0;d--){
            if(d==2)
                continue;
            Arrays.fill(count,0);
            for(int i=0;i<timePoints.size();i++){
                count[Character.getNumericValue(timePoints.get(i).charAt(d))]++;
            }
            for(int i=1;i<10;i++){
                count[i] += count[i-1];
            }
            for(int i=help.length-1;i>=0;i--){
                help[--count[Character.getNumericValue(timePoints.get(i).charAt(d))]] = timePoints.get(i);
            }
            timePoints.clear();
            for(int i=0;i<help.length;i++){
                timePoints.add(help[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++){
            int tmp = (Integer.valueOf(timePoints.get(i).substring(0,2))-Integer.valueOf(timePoints.get(i-1).substring(0,2)))*60+
                    Integer.valueOf(timePoints.get(i).substring(3))-Integer.valueOf(timePoints.get(i-1).substring(3));
            if(res>tmp)
                res = tmp;
        }
        int tmp = (23-Integer.valueOf(timePoints.get(timePoints.size()-1).substring(0,2)))*60+(60-Integer.valueOf(timePoints.get(timePoints.size()-1).substring(3)))+
                Integer.valueOf(timePoints.get(0).substring(0,2))*60+Integer.valueOf(timePoints.get(0).substring(3));
        return res<tmp?res:tmp;
    }

    public static void main(String[] args) {
        No539_FindMinDifference obj = new No539_FindMinDifference();
        List<String> l = new LinkedList<>();
        l.add("23:59");
        l.add("00:00");
        System.out.println(obj.findMinDifference(l));

    }
}
