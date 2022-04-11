package Coding_Interviews;

public class No5_MaxProduct {
    public int maxProduct(String[] words) {
        int[] letter = new int[26];
        int digit = 1;
        for (int i = 0; i < 26; i++) {
            letter[i] = digit;
            digit <<= 1;
        }
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i] |= letter[words[i].charAt(j)-'a'];
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
