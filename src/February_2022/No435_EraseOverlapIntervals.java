package February_2022;

import java.util.Arrays;
import java.util.Comparator;

public class No435_EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        boolean[] visited = new boolean[intervals.length];
        Arrays.fill(visited,false);
        int count = 0;
        int index = 0;
        while(index<intervals.length){
            if(!visited[index]){
                int right = intervals[index][1];
                visited[index] = true;
                count++;
                index++;
                while(index<intervals.length&&!visited[index]&&right>intervals[index][0]){
                    visited[index] = true;
                    index++;
                }
            }
        }
        return intervals.length-count;
    }

    public static void main(String[] args) {
        No435_EraseOverlapIntervals obj = new No435_EraseOverlapIntervals();
//        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = new int[][]{{1,2},{1,2},{1,2}};
//        int[][] intervals = new int[][]{{1,2},{2,3}};
        int[][] intervals = new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }
}
