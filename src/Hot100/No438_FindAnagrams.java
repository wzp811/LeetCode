package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No438_FindAnagrams {
    public List<Integer> findAnagrams1(String s,String p){
        List<Integer> ans = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<p.length();i++){
            int cnt = map.getOrDefault(p.charAt(i),new Integer(0));
            map.put(p.charAt(i),cnt+1);
            set.add(p.charAt(i));
        }
        for(int i=0;i<p.length();i++){
            if(set.contains(s.charAt(i))){
                int cnt = map.getOrDefault(s.charAt(i),new Integer(0));
                if(cnt==1) map.remove(s.charAt(i));
                else map.put(s.charAt(i),cnt-1);
            }
        }
        if(map.isEmpty()) ans.add(0);
        for(int i=p.length();i<s.length();i++){
            if(set.contains(s.charAt(i-p.length()))){
                int cnt = map.getOrDefault(s.charAt(i-p.length()),new Integer(0));
                if(cnt==-1) map.remove(s.charAt(i-p.length()));
                else map.put(s.charAt(i-p.length()),cnt+1);
            }
            if(set.contains(s.charAt(i))){
                int cnt = map.getOrDefault(s.charAt(i),new Integer(0));
                if(cnt==1) map.remove(s.charAt(i));
                else map.put(s.charAt(i),cnt-1);
            }
            if(map.isEmpty()) ans.add(i-p.length()+1);
        }
        return ans;
    }

    public List<Integer> findAnagrams(String s,String p){
        List<Integer> ans = new LinkedList<>();
        if(s.length()<p.length()) return ans;
        int[] count = new int[26];
        int differCount = 0;
        for(int i=0;i<p.length();i++){
            if(count[p.charAt(i)-'a']==0) differCount++;
            count[p.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==0) differCount++;
            count[s.charAt(i)-'a']--;
            if(count[s.charAt(i)-'a']==0) differCount--;
            if(i>=p.length()) {
                if(count[s.charAt(i-p.length())-'a']==0) differCount++;
                count[s.charAt(i - p.length()) - 'a']++;
                if(count[s.charAt(i-p.length())-'a']==0) differCount--;
            }
            if(differCount==0) ans.add(i-p.length());
        }
        return ans;
    }
}
