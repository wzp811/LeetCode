package Examinations.JD;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        if (s.length() > 18) {
            System.out.println(-1);
            return;
        }
        long k = Long.parseLong(s);
        if (k == 1) {
            System.out.println(1);
            return;
        }
        long a = 1, b = 2;
        List<Long> list = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();
        int len = 2;
        list.add(b);
        map.put(b, len++);
        while (a + b > 0 && a + b < Long.MAX_VALUE) {
            list.add(a + b);
            map.put(a + b, len++);
            long tmp = a;
            a = b;
            b += tmp;
        }
        List<Long> app = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (k > 0 && k % list.get(i) == 0) {
                k /= list.get(i);
                app.add(list.get(i));
            }
            if (k == 1) break;
        }
        if (k != 1 || list.size() == 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendN(sb, map.get(app.get(0)));
        for (int i = 1; i < app.size(); i++) {
            sb.append("9");
            appendN(sb, map.get(app.get(i)));
        }
        sb.append("1");
        System.out.println(sb.toString());
    }

    public static void appendN(StringBuilder sb, int t) {
        for (int i = 0; i < t - 1; i++) sb.append("1");
    }
}
