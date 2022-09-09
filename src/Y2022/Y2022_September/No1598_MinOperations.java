package Y2022.Y2022_September;

public class No1598_MinOperations {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].substring(0, 2).equals("..")) {
                cnt = Math.max(0, cnt - 1);
            } else if (logs[i].charAt(0) != '.') {
                cnt++;
            }
        }
        return cnt;
    }
}
