package QuestionList.QuestOfTheDay;

public class No1021_RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                if (cnt == 1) continue;
            } else {
                cnt--;
                if (cnt == 0) continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
