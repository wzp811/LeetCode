package Y2022.Y2022_November;

public class No1704_HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int leftCnt = 0, rightCnt = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            leftCnt += isVowel(s.charAt(i));
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            rightCnt += isVowel(s.charAt(i));
        }
        return leftCnt == rightCnt;
    }

    public int isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        } else {
            return 0;
        }
    }
}
