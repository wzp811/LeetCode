package QuestionList.CodeCapriccio;

import java.util.HashSet;
import java.util.Set;

public class No202_IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n) && n != 1) {
            int newNum = 0;
            while (n > 0) {
                newNum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = newNum;
        }
        return n == 1;
    }
}
