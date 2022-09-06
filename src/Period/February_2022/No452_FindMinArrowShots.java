package Period.February_2022;

import java.util.Arrays;
import java.util.Comparator;

public class No452_FindMinArrowShots {
    public int findMinArrowShots(int[][] points){
        int count = 0;
        boolean[] visited = new boolean[points.length];
        Arrays.fill(visited,false);
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        });
        for(int i=0;i<points.length;i++){
            System.out.println(points[i][0]+" "+points[i][1]);
        }
        int index = 0;
        while(index<points.length){
            if(!visited[index]){
                int right = points[index][1];
                visited[index] = true;
                count++;
                index++;
                while(index<points.length&&!visited[index]&&points[index][0]<=right){
                    right = Math.min(right,points[index][1]);
                    visited[index] = true;
                    index++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No452_FindMinArrowShots obj = new No452_FindMinArrowShots();
//        int[][]points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][]points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
//        int[][]points = new int[][]{{1,2}};
//        int[][]points = new int[][]{{2,3},{2,3}};
//        int[][]points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
//        int[][]points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        System.out.println(obj.findMinArrowShots(points));
//        System.out.println(Integer.MIN_VALUE);
    }
}
