package Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No81_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(res, cur, candidates, target, 0);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            if (target == 0) res.add(new LinkedList<>(cur));
            return;
        }
        process(res, cur, candidates, target, index + 1);
        if (target < candidates[index]) return;
        int cnt = 0;
        while (target > 0) {
            cur.add(candidates[index]);
            target -= candidates[index];
            process(res, cur, candidates, target, index + 1);
            cnt++;
        }
        while (cnt > 0) {
            cur.remove(cur.size() - 1);
            cnt--;
        }
    }
}
