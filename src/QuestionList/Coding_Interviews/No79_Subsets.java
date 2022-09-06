package QuestionList.Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No79_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(res, cur, nums, 0);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new LinkedList<>(cur));
            return;
        }
        process(res, cur, nums, index + 1);
        cur.add(nums[index]);
        process(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
    }
}
