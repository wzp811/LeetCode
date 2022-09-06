package QuestionList.QuestOfTheDay;

public class No01_05_OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;
        if (first.equals(second)) return true;
        if (first.length() == second.length()) {
            int cnt = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) cnt++;
            }
            return cnt == 1;
        }
        int f = 0, s = 0;
        while (first.charAt(f) == second.charAt(s)) {
            f++;
            s++;
        }
        int last = f;
        f = first.length() - 1;
        s = second.length() - 1;
        while (first.charAt(f) == second.charAt(s)) {
            f--;
            s--;
        }
        return f == last;
    }
}
