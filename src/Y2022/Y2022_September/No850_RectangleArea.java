package Y2022.Y2022_September;

import java.util.*;

public class No850_RectangleArea {
    public int rectangleArea(int[][] rectangles) {
        int mod = (int) (10e9 + 7);
        long res = 0;
        List<Integer> xlist = new ArrayList<>();
        for (int[] rect : rectangles) {
            xlist.add(rect[0]);
            xlist.add(rect[2]);
        }
        Collections.sort(xlist);
        System.out.println(xlist);
        for (int i = 1; i < xlist.size(); i++) {
            if (xlist.get(i - 1) == xlist.get(i)) continue;
            List<int[]> ylist = new ArrayList<>();
            int x1 = xlist.get(i - 1);
            int x2 = xlist.get(i);
            for (int[] rect : rectangles) {
                if (rect[0] <= x1 && rect[2] >= x2) {
                    ylist.add(new int[]{rect[3], rect[1]});
                }
            }
            if (ylist.size() == 0) continue;
            Collections.sort(ylist, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o2[1] - o1[1];
                    return o2[0] - o1[0];
                }
            });
            for (int j = 0; j < ylist.size(); j++) {
                System.out.println(Arrays.toString(ylist.get(j)));
            }
            long height = 0;
            long y1 = ylist.get(0)[0];
            long y2 = ylist.get(0)[1];
            for (int j = 1; j < ylist.size(); j++) {
                if (ylist.get(j)[0] < y2) {
                    height += y1 - y2;
                    y1 = ylist.get(j)[0];
                    y2 = ylist.get(j)[1];
                } else {
                    y1 = Math.max(y1, ylist.get(j)[0]);
                    y2 = Math.min(y2, ylist.get(j)[1]);
                }
            }
            height += y1 - y2;
            System.out.println(height + " " + x2 + " " + x1);
            res += height * (x2 - x1);
            res %= mod;
        }
        return (int) res;
    }
}
