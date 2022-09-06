package QuestionList.Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No83_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        process(res, cur, nums, 0, visited);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[] nums, int len, boolean[] visited) {
        if (len == nums.length) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                process(res, cur, nums, len + 1, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
        return;
    }
}
