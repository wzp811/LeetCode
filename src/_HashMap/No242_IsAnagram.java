package _HashMap;

import java.util.HashMap;
import java.util.Map;

public class No242_IsAnagram {
    public boolean isAnagram(String s,String t){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),new Integer(0))+1);
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))) return false;
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
            if(map.get(t.charAt(i))==0) map.remove(t.charAt(i));
        }
        return map.isEmpty();
    }
}
