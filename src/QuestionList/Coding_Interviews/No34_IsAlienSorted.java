package QuestionList.Coding_Interviews;

public class No34_IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        int index = 0;
        while (true) {
            int rest = 0;
            int last = -1;
            int equalCnt = 0;
            for (int i = 0; i < words.length; i++) {
                if (index < words[i].length()) {
                    rest++;
                    if (last > orders[words[i].charAt(index) - 'a']) return false;
                    if (last == orders[words[i].charAt(index) - 'a']) equalCnt++;
                    last = orders[words[i].charAt(index) - 'a'];
                } else {
                    if (last != -1) return false;
                }
            }
            index++;
            if (equalCnt == 0) return true;
            if (rest == 0) return true;
        }
    }
}
