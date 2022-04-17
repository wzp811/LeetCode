package Coding_Interviews;

import java.util.*;

public class No33_GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        int[] primes = new int[]{2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int num = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                num *= primes[strs[i].charAt(j) - 'a'];
                List<String> list = map.getOrDefault(num, new ArrayList<>());
                list.add(strs[i]);
                map.put(num, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list: map.values()) res.add(list);
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[]chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String cur = new String(chs);
            List<String> curList = map.getOrDefault(cur, new ArrayList<>());
            curList.add(strs[i]);
            map.put(cur, curList);
        }
        for (List<String> list: map.values()) ans.add(list);
        return ans;
    }
}
