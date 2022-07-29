package Y2022_July;

import java.util.HashSet;
import java.util.Set;

public class No593_ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        int[][] p = new int[][] {p1, p2, p3, p4};
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                int a = p[i][0] - p[j][0];
                int b = p[i][1] - p[j][1];
                if (a == 0 && b == 0) return false;
                set.add(a * a + b * b);
            }
        }
        return set.size() == 2;
    }
}
