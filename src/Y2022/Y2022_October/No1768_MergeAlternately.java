package Y2022.Y2022_October;

public class No1768_MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder res = new StringBuilder();
        while (index1 < word1.length() && index2 < word2.length()) {
            res.append(word1.charAt(index1++));
            res.append(word2.charAt(index2++));
        }
        while (index1 < word1.length()) {
            res.append(word1.charAt(index1++));
        }
        while (index2 < word2.length()) {
            res.append(word2.charAt(index2++));
        }
        return new String(res);
    }
}
