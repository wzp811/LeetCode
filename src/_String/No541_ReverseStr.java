package _String;

public class No541_ReverseStr {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        boolean reverse = true;
        int index = 0;
        while (index < s.length()) {
            if (reverse) {
                for (int i = 0; i < Math.min(s.length()-index, k) / 2; i++) {
                    char tmp = str[i + index];
                    str[i + index] = str[Math.min(index + k, s.length()) - 1 - i];
                    str[Math.min(index + k, s.length()) - 1 - i] = tmp;
                }
            }
            index += k;
            reverse = !reverse;
        }
        return new String(str);
    }
}
