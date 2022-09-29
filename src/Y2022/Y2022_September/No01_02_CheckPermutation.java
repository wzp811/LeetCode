package Y2022.Y2022_September;

import java.util.Arrays;
import java.util.Locale;

public class No01_02_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < s1.length(); i++) {
            if (ch1[i] != ch2[i]) return false;
        }
        return true;
    }
}
