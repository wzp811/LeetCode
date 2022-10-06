package Examinations.ChinaRenShou;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] k = input.nextLine().split(",");
        Set<String> cards = new HashSet<>();
        for (String card : k) cards.add(card);
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (cards.contains(str.substring(j, i))) dp[i] |= dp[j];
            }
        }
        System.out.println(dp[str.length()]);
    }
}
