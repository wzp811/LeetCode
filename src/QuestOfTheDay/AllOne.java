package QuestOfTheDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    int maxlen = 0;
    int minlen = Integer.MAX_VALUE;
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, Set<String>> count = new HashMap<>();
    public AllOne() {

    }

    public void inc(String key) {
        int curCount = map.getOrDefault(key,0);
        map.put(key,curCount+1);
        maxlen = Math.max(maxlen,curCount+1);
        minlen = Math.min(minlen,curCount+1);
        Set<String> set = count.getOrDefault(curCount+1,new HashSet<>());
        set.add(key);
        count.put(curCount+1,set);
        if(curCount>0){
            set = count.get(curCount);
            set.remove(key);
            if(set.size()==0) {
                count.remove(curCount);
                if(minlen==curCount) minlen++;
            }
            else {
                count.put(curCount, set);
                minlen = Math.min(minlen,curCount);
            }
        }
    }

    public void dec(String key) {
        int curCount = map.get(key);
        map.put(key,curCount-1);
        if(map.get(key)==0) map.remove(key);
        Set<String> set = count.get(curCount);
        set.remove(key);
        if(set.size()==0) {
            count.remove(curCount);
            if(maxlen==curCount) maxlen--;
            if(minlen==curCount) {
                for (int i = 1; i <= maxlen; i++) {
                    if (count.containsKey(i)) {
                        minlen = i;
                        break;
                    }
                }
            }
        }
        else {
            count.put(curCount, set);
        }
        if(curCount!=1){
            set = count.get(curCount-1);
            set.add(key);
            count.put(curCount-1,set);
            minlen = Math.min(curCount-1,minlen);
        }
    }

    public String getMaxKey() {
        if(map.size()==0) return "";
        for(String i:count.get(maxlen)){
            return i;
        }
        return "";
    }

    public String getMinKey() {
        System.out.println(minlen);
        if(map.size()==0) return "";
        for(String i:count.get(minlen)){
            return i;
        }
        return "";
    }
}

/*
["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
[[],["hello"],["hello"],[],[],["leet"],[],[]]
 */
/*
["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","dec","getMaxKey","getMinKey"]
[[],["a"],["b"],["b"],["b"],["c"],["b"],["b"],["a"],["c"],[],[]]

 */