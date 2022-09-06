package Tags._SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class No3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 1;
        int res = 0;
        set.add(s.charAt(0));
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                res = Math.max(right - left + 1, res);
                right++;
            } else {
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left++));
                }
                left++;
                right++;
            }
        }
        return res;
    }
}
