package LeetCodeContest.Weekly312;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Object[][] tmp = new Object[names.length][2];
        for (int i = 0; i < names.length; i++) {
            tmp[i][0] = names[i];
            tmp[i][1] = heights[i];
        }
        Arrays.sort(tmp, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return (int)o2[1] - (int)o1[1];
            }
        });
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (String) tmp[i][0];
        }
        return res;
    }
}
