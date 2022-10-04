package Y2022.Y2022_October;

public class No1784_CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        int cnt = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' || s.charAt(i - 1) == '1') continue;
            if (s.charAt(i) == '1') cnt++;
        }
        return cnt < 2;
    }
}
