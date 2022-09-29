package Examinations.ByteDance;

import java.util.*;

public class Test4 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int n = input.nextInt();
        String[] k = s.split(" ");
        int[] a = new int[k.length];
        for (int i = 0; i < k.length; i++) a[i] = Integer.valueOf(k[i]);
        Arrays.sort(a);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> tmp = new HashSet<>();
        tmp.add(0);
        map.put(0, tmp);
        for (int i = a.length - 1; i >= 0; i--) {
            int num = n;
            if (i == 0) num = n + a[i] - 1;
            for (int j = a[i]; j <= num; j++) {
                Set<Integer> set = map.getOrDefault(j - a[i], new HashSet<>());
                Set<Integer> curSet = map.getOrDefault(Math.min(n, j), new HashSet<>());
                for (int key : set){
                    curSet.add(key + 1);
                }
                map.put(Math.min(n, j), curSet);
            }
        }
//         System.out.println(map);
        System.out.println(map.get(n).size());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int n = input.nextInt();
        String[] k = s.split(" ");
        int[] a = new int[k.length];
        for (int i = 0; i < k.length; i++) a[i] = Integer.valueOf(k[i]);
        Arrays.sort(a);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            int num = n;
            if (i == 0)
            for (int j = a[i]; j <= n; j++) {
                dp[j] += dp[j - a[i]];
            }
        }
        System.out.println(dp[n]);
    }
}
