package February_2022;

import java.util.HashSet;

public class No1763_LongestNiceSubstring {
    public String longestNiceSubstring(String s){
        int maxlen = 0;
        int begin = 0;
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> all = new HashSet<>();
        for(int i=0;i<s.length();i++){
            lower.clear();
            all.clear();
            for(int j=i;j<s.length();j++){
                char lowerCase = Character.toLowerCase(s.charAt(j));
                all.add(s.charAt(j));
                lower.add(lowerCase);
                if(all.size()==2*lower.size()){
                    if(maxlen<j-i+1){
                        maxlen = j-i+1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    public static void main(String[] args) {
        No1763_LongestNiceSubstring obj = new No1763_LongestNiceSubstring();
        System.out.println(obj.longestNiceSubstring("YazakApay"));
    }
}
