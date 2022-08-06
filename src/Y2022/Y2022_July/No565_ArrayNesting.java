package Y2022.Y2022_July;

import java.util.HashSet;
import java.util.Set;

public class No565_ArrayNesting {
    public int arrayNesting1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] len = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) continue;
            int cur = num;
            int tmp = 0;
            while (!set.contains(cur)) {
                set.add(cur);
                cur = nums[cur];
                tmp++;
            }
            if (cur == num) {
                res = Math.max(res, tmp);
                len[num] = tmp;
            } else {
                tmp += len[cur];
                res = Math.max(res, tmp);
                len[num] = tmp;
            }
        }
        return res;
    }


    // 图的dfs
    // 由于每个节点的出度和入度至多都为1，对于在环上的一个节点，只可能处于一个环内
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int cur = nums[i];
            while (visited[cur]) {
                visited[cur] = true;
                cur = nums[cur];
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
