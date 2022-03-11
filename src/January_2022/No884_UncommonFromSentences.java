package January_2022;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class No884_UncommonFromSentences {
    public String[] uncommonFromSentences(String s1,String s2){
        List<String> res = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int index = 0;
        for(int i=0;i<=s1.length();i++){
            if(i==s1.length()||s1.charAt(i)==' '){
                String tmp = s1.substring(index,i);
                index = i+1;
                int count = map.getOrDefault(tmp,new Integer(0));
                map.put(tmp,count+1);
            }
        }
        index = 0;
        for(int i=0;i<=s2.length();i++){
            if(i==s2.length()||s2.charAt(i)==' '){
                String tmp = s2.substring(index,i);
                index = i+1;
                int count = map.getOrDefault(tmp,new Integer(0));
                map.put(tmp,count+1);
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        No884_UncommonFromSentences obj = new No884_UncommonFromSentences();
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String[] res = obj.uncommonFromSentences(s1,s2);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
