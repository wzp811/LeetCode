package LeetCodeContest.Biweekly84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(items1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(items2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0, j = 0;
        while (i < items1.length && j < items2.length) {
            List<Integer> cur = new ArrayList<>();
            if (items1[i][0] == items2[j][0]) {
                cur.add(items1[i][0]);
                cur.add(items1[i++][1] + items2[j++][1]);
                res.add(cur);
            } else if (items1[i][0] < items2[j][0]) {
                cur.add(items1[i][0]);
                cur.add(items1[i++][1]);
                res.add(cur);
            } else {
                cur.add(items2[j][0]);
                cur.add(items2[j++][1]);
                res.add(cur);
            }
        }
        while (i < items1.length) {
            List<Integer> cur = new ArrayList<>();
            cur.add(items1[i][0]);
            cur.add(items1[i++][1]);
            res.add(cur);
        }
        while (j < items1.length) {
            List<Integer> cur = new ArrayList<>();
            cur.add(items2[j][0]);
            cur.add(items2[j++][1]);
            res.add(cur);
        }

        return res;
    }
}
