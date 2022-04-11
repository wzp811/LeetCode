package Coding_Interviews;

public class No2_AddBinary {
    public String addBinary(String a, String b) {
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 1; i <= Math.max(a.length(), b.length()); i++) {
            int cur = last;
            if (a.length() - i >= 0) cur += a.charAt(a.length() - i) - '0';
            if (b.length() - i >= 0) cur += b.charAt(b.length() - i) - '0';
            if (cur >= 2) last = 1;
            else last = 0;
            sb.append((char)(cur % 2 + '0'));
        }
        if (last == 1) sb.append('1');
        sb.reverse();
        return new String(sb);
    }
}
