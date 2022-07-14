package CodeCapriccio;

public class No383_CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
            if (count[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
