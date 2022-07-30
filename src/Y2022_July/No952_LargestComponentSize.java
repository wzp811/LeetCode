package Y2022_July;

import java.util.*;

public class No952_LargestComponentSize {
    public int largestComponentSize1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            int cnt = 1;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.addLast(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int cur = queue.pollFirst();
                for (int j = i + 1; j < nums.length; j++) {
                    if (!visited[j] && getFactor(cur, nums[j]) > 1) {
                        visited[j] = true;
                        queue.addLast(j);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public int getFactor(int x, int y) {
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    int[] parent;
    int[] size;

    public int largestComponentSize(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 2; j * j <= cur; j++) {
                if (cur % j == 0) {
                    List<Integer> list = map.getOrDefault(j, new ArrayList<>());
                    list.add(i);
                    map.put(j, list);
                }
                while (cur % j == 0) cur /= j;
            }
            if (cur > 1) {
                List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
                list.add(i);
                map.put(cur, list);
            }
        }
        parent = new int[nums.length];
        size = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size(); i++) union(list.get(0), list.get(i));
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) res = Math.max(res, size[i]);
        return res;
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        parent[pb] = parent[pa];
        size[pa] += size[pb];
    }

    public int find(int a) {
        if (parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }
}
