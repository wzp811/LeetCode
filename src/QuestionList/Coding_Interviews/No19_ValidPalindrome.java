package QuestionList.Coding_Interviews;

public class No19_ValidPalindrome {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean hasDeleted = false;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                break;
            }
        }
        int i1 = i, j1 = j - 1;
        int i2 = i + 1, j2 = j;
        int cnt = 0;
        while(i1 < j1) {
            if (s.charAt(i1++) != s.charAt(j1--)) {
                cnt++;
                break;
            }
        }
        while (i2 < j2) {
            if (s.charAt(i2++) != s.charAt(j2--)) {
                cnt++;
                break;
            }
        }
        return cnt < 2;
    }
}
