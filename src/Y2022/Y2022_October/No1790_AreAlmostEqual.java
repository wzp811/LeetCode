package Y2022.Y2022_October;

public class No1790_AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] index = new int[2];
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (cnt == 2) return false;
            index[cnt++] = i;
        }
        return cnt == 0 || cnt == 2 && s1.charAt(index[0]) == s2.charAt(index[1]) && s1.charAt(index[1]) == s2.charAt(index[0]);
    }
}
