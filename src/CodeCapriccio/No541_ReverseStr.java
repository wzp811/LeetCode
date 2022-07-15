package CodeCapriccio;

public class No541_ReverseStr {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int l = Math.min(s.length() - i, k);
            for (int j = 0; j < l / 2; j++) {
                char tmp = ch[i + j];
                ch[i + j] = ch[i + l - 1 - j];
                ch[i + l - 1 - j] = tmp;
            }
        }
        return new String(ch);
    }
}
