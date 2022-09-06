package QuestionList.QuestOfTheDay;

public class No942_DiStringMatch {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int left = 0, right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[s.length()] = left;
        return res;
    }
}
