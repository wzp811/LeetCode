package Coding_Inerviews_2th;

import java.util.HashMap;
import java.util.Map;

public class No48_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        int dp = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) dp = Math.min(dp+1,i-map.get(s.charAt(i)));
            else dp++;
            max = Math.max(max,dp);
            System.out.println(dp+" "+max);
            map.put(s.charAt(i),i);
        }
        return max;
    }

    public static void main(String[] args) {
        No48_LengthOfLongestSubstring obj = new No48_LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
