package Period.February_2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No406_RecontructQueue {
    public int[][] reconstructQueue(int[][] people){
        List<int[]> res = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        for(int i=0;i<people.length;i++){
            res.add(people[i][1],people[i]);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        No406_RecontructQueue obj = new No406_RecontructQueue();
//        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int [][] res = obj.reconstructQueue(people);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
