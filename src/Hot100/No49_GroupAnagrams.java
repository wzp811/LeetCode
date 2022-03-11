package Hot100;

import java.util.*;

public class No49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[]arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> cur = map.getOrDefault(key,new LinkedList<>());
            cur.add(str);
            map.put(key,cur);
        }
        return new LinkedList<>(map.values());
    }
    public List<List<String>> groupAnagrams1(String[] strs){
        List<List<String>> res = new LinkedList<>();
        if(strs.length==0) return res;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String tmp = calc(strs[i]);
            List<String> cur;
            if(map.containsKey(tmp)) cur = map.get(tmp);
            else cur = new LinkedList<>();
            cur.add(strs[i]);
            map.put(tmp,cur);
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet())
            res.add(entry.getValue());
        return res;

    }
    public String calc(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    public static void main(String[] args) {
        No49_GroupAnagrams obj = new No49_GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));
    }
}
