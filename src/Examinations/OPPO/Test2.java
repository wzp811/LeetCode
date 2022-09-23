package Examinations.OPPO;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c = input.nextInt();
        input.nextLine();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            input.nextLine();
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
        }
        Set<Integer> set = new HashSet<>();
        set.add(c);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(c);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                if (!map.containsKey(cur)) continue;
                List<Integer> list = map.get(cur);
                for (int next : list) {
                    if (set.contains(next)) continue;
                    set.add(next);
                    queue.addLast(next);
                }
            }
        }
        System.out.println(set.size());
    }
}
