package February_2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No56_Merge {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        int left = 0;
        int right = 0;
        int index = 0;
        boolean[] visited = new boolean[intervals.length];
        Arrays.fill(visited,false);
        while(index<intervals.length){
            if(!visited[index]) {
                visited[index] = true;
                right = intervals[index][1];
                left = intervals[index][0];
                index++;
                while (index < intervals.length && intervals[index][0] <= right) {
                    visited[index] = true;
                    right = Math.max(right, intervals[index][1]);
                    index++;
                }
                res.add(new int[]{left,right});
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        No56_Merge obj = new No56_Merge();
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        int[][] res = obj.merge(intervals);
        System.out.println(res.length);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
