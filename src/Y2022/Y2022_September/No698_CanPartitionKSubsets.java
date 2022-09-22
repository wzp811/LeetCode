package Y2022.Y2022_September;

import java.util.Arrays;

public class No698_CanPartitionKSubsets {
    int k;
    int size;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if (sum % k != 0) return false;
        this.size = sum / k;
        if (Arrays.stream(nums).max().getAsInt() > size) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, 0, 0, nums.length);
    }

    public boolean dfs(int[] nums, boolean[] visited, int cur, int cnt, int index) {
        if (cur == size) {
            cnt++;
            cur = 0;
            index = nums.length;
        }
        if (cnt == k) return true;
        boolean ret = false;
        for (int i = index - 1; i >= 0; i--) {
            if (visited[i] || cur + nums[i] > size) continue;
            visited[i] = true;
            cur += nums[i];
            ret |= dfs(nums, visited, cur, cnt, i);
            cur -= nums[i];
            visited[i] = false;
        }
        return ret;
    }

    public boolean dfs1(int[] nums, int[] tmp, int rest, int index) {
        System.out.println(Arrays.toString(tmp));
        System.out.println(rest + " " + index);
        if (index >= nums.length) {
            return rest == 0;
        }
        int last = rest;
        for (int i = 0; i < tmp.length; i++) {
            if (nums[index] > tmp[i]) continue;
            tmp[i] -= nums[index];
            if (tmp[i] == 0) {
                rest--;
            }
            tmp[i] += nums[index];
            rest = last;
        }
        return false;
    }

    public static void main(String[] args) {
        No698_CanPartitionKSubsets obj = new No698_CanPartitionKSubsets();
        int[] nums = new int[]{3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};
        System.out.println(obj.canPartitionKSubsets(nums, 6));
    }
}
