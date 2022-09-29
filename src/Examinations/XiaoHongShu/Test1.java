package Examinations.XiaoHongShu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        Set<Integer> set = new HashSet<>();
        for (int i = 0;  i < n; i++) {
            int cur = input.nextInt();
            set.add(cur);
        }
        int index = 1;
        while (set.contains(index)) {
            index++;
        }
        System.out.println(index - 1);
    }
}
