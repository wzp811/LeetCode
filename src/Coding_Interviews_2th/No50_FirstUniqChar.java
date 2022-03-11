package Coding_Interviews_2th;

public class No50_FirstUniqChar {
    public char firstUniqChar(String s){
        int[] cnt = new int[26];
        for(int i=0;i<s.length();i++) cnt[(int)(s.charAt(i)-'a')]++;
        for(int i=0;i<s.length();i++){
            if(cnt[(int)(s.charAt(i)-'a')]==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
