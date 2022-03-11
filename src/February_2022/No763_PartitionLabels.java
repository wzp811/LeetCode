package February_2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No763_PartitionLabels {
    public List<Integer> partitionLabels(String s){
        List<Integer> res = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int index = 0;
        while(index<s.length()){
            int indexcpy = index;
            int right = map.get(s.charAt(index));
            while(index<right){
                right = Math.max(right,map.get(s.charAt(index)));
                index++;
            }
            res.add(right-indexcpy+1);
            index = right+1;
        }
        return res;
    }

    public static void main(String[] args) {
        No763_PartitionLabels obj = new No763_PartitionLabels();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
