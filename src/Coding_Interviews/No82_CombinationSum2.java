package Coding_Interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No82_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) sum += candidates[i];
        process(res, cur, candidates, 0, target, sum);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int target, int restSum) {
        if (index == candidates.length || restSum < target) {
            if (target == 0) res.add(new LinkedList<>(cur));
            return;
        }
        int tmp = index + 1;
        int tmpSum = restSum - candidates[index];
        while (tmp < candidates.length && candidates[tmp] == candidates[tmp - 1]) {
            tmpSum -= candidates[tmp];
            tmp++;
        }
        process(res, cur, candidates, tmp, target, tmpSum);
        cur.add(candidates[index]);
        if (target - candidates[index] >= 0) process(res, cur, candidates, index + 1, target - candidates[index], restSum - candidates[index]);
        cur.remove(cur.size() - 1);
        return;
    }

}
