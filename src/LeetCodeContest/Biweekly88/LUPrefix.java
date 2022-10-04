package LeetCodeContest.Biweekly88;

public class LUPrefix {
    boolean[] v;
    int last = 0;
    public LUPrefix(int n) {
        v = new boolean[n + 1];
    }

    public void upload(int video) {
        v[video] = true;
    }

    public int longest() {
        while (last + 1 < v.length && v[last + 1]) last++;
        return last - 1;
    }
}
