package QuestionList.Coding_Interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No84_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        process(res, cur, nums, 0, visited);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[] nums, int len, boolean[] visited) {
        if (len == nums.length) {
            res.add(new LinkedList<>(cur));
            return;
        }
        boolean hasProcess = false;
        int last = -11;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && hasProcess && nums[i] == last) continue;
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                process(res, cur, nums, len + 1, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
                hasProcess = true;
                last = nums[i];
            }
        }
    }
}
