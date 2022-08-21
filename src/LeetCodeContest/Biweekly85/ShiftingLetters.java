package LeetCodeContest.Biweekly85;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] shift = new int[s.length()];
        char[] res = new char[s.length()];
        PriorityQueue<Integer> start1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> end1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> start2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> end2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 1) {
                start1.add(shifts[i][0]);
                end1.add(shifts[i][1]);
            } else {
                start2.add(shifts[i][0]);
                end2.add(shifts[i][1]);
            }
        }
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!start1.isEmpty() && i >= start1.peek()) {
                cur++;
                start1.poll();
            }
            while (!start2.isEmpty() && i >= start2.peek()) {
                cur--;
                start2.poll();
            }
            shift[i] = cur;
            res[i] = (char) ((char) (s.charAt(i) - 'a' + cur) % 26 + 'a');
            while (!end1.isEmpty() && i >= end1.peek()) {
                cur--;
                end1.poll();
            }
            while (!end2.isEmpty() && i >= end2.peek()) {
                cur++;
                end2.poll();
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(-5 % 26);
    }
}
