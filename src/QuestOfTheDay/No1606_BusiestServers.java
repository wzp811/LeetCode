package QuestOfTheDay;

import java.util.*;

public class No1606_BusiestServers {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int max = 0;
        int[] cnt = new int[k];
        for(int i=0;i<k;i++) available.add(i);

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                available.add(busy.poll()[0]);
            }
            if (available.isEmpty()) continue;
            Integer cur = available.ceiling(i % k);
            cur = cur == null ? available.first() : cur;
            available.remove(cur);
            busy.add(new int[]{cur, arrival[i] + load[i]});
            cnt[cur]++;
            if (cnt[cur] == max) {
                res.add(cur);
            } else if (cnt[cur] > max) {
                res.clear();
                max = cnt[cur];
                res.add(cur);
            }
        }
        return res;
    }
}
