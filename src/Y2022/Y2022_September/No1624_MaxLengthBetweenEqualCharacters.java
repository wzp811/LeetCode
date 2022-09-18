package Y2022.Y2022_September;

import java.util.Arrays;

public class No1624_MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indexs = new int[26];
        Arrays.fill(indexs, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (indexs[index] == -1) {
                indexs[index] = i;
            } else {
                res = Math.max(res, i - indexs[index] - 1);
            }
        }
        return res;
    }
}
