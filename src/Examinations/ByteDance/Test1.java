package Examinations.ByteDance;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> children = new HashSet<>();
        String[][] k = new String[n][];
        for (int i = 0; i < n; i++) {
            String s = input.nextLine();
            k[i] = s.split(" ");
            for (int j = 0; j < k[i].length - 1; j++) {
                HashSet<String> set = map.getOrDefault(k[i][j], new HashSet<>());
                set.add(k[i][j + 1]);
                map.put(k[i][j], set);
                children.add(k[i][j + 1]);
            }
        }
        String father = null;
        for (int i = 0; i < n; i++) {
            if (!children.contains(k[i][0])) {
                father = k[i][0];
                System.out.println(k[i][0]);
                break;
            }
        }
        int p = input.nextInt();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(father);
        for (int i = 1; i < p; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.pollFirst();
                HashSet<String> set = map.get(cur);
                if (set == null) continue;
                for (String str : set) queue.addLast(str);
            }
        }
        System.out.println(queue.size());
    }
}
