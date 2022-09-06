package QuestionList.Coding_Interviews;

public class No18_IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isLetter(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String res = new String(sb);
        for (int i = 0; i < res.length() / 2; i++) {
            if (res.charAt(i) != res.charAt(res.length() - i - 1)) return false;
        }
        return true;
    }
}
