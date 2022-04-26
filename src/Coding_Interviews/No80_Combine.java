package Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No80_Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(res, cur, n, k, 0);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int n, int k, int index) {
        if (index == n + 1) {
            if (k == 0) res.add(new LinkedList<>(cur));
            return;
        }
        if (n - index < k) return;
        process(res, cur, n, k, index + 1);
        cur.add(index);
        process(res, cur, n, k - 1, index + 1);
        cur.remove(cur.size() - 1);
    }
}
