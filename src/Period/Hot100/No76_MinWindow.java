package Period.Hot100;

import java.util.*;

public class No76_MinWindow {
    public String minWindow1(String s,String t){
        int l = 0, r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<t.length();i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), new Integer(0)) + 1);
            set.add(t.charAt(i));
        }
        System.out.println(set);
        System.out.println(map);
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
            }
            if(map.isEmpty()){
                r = i;
                break;
            }
        }
        System.out.println(l+" "+r);
        if(!map.isEmpty()) return "";
        Character lack = '0';
        int[] res = new int[2];
        res[0] = 0;
        res[1] = s.length();
        while(r<s.length()&&l<s.length()){
            if(r==s.length()-1||lack=='0'){
                if(set.contains(s.charAt(l))) lack = s.charAt(l);
                l++;
            }else{
                r++;
                if(lack==s.charAt(r)) lack = '0';
            }
            if(lack=='0'){
                if (r - l < res[1] - res[0]) {
                    res[0] = l;
                    res[1] = r;
                }
            }
        }
        return s.substring(res[0],res[1]);
    }

    public String minWindow(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), new Integer(0)) + 1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()) map.put(entry.getKey(),-entry.getValue());
        int l = 0, r = 0;
        int[]res = new int[2];
        res[0] = 0; res[1] = s.length()+1;
        while(l<s.length()){
            boolean suc = true;
            for(Map.Entry<Character,Integer> entry:map.entrySet()) if(entry.getValue()<0){ suc = false;break;}
            if(suc||r==s.length()){
                if(suc&&res[1]-res[0]>r-l) res = new int[]{l, r};
                if(map.containsKey(s.charAt(l))) map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }else{
                if(map.containsKey(s.charAt(r))) map.put(s.charAt(r),map.get(s.charAt(r))+1);
                r++;
            }
        }
        if(res[1]==s.length()+1) return "";
        else return s.substring(res[0],res[1]);
    }

    public static void main(String[] args) {
        No76_MinWindow obj = new No76_MinWindow();
        System.out.println(obj.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(obj.minWindow("a","a"));
    }
}
