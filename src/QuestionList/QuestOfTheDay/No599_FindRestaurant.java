package QuestionList.QuestOfTheDay;

import java.util.*;

public class No599_FindRestaurant {
    public String[] findRestaurant(String[] list1,String[] list2){
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int min = list1.length+list2.length;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                if(min>map.get(list2[i])+i){
                    ans.clear();
                    ans.add(list2[i]);
                    min = map.get(list2[i])+i;
                }else if(min==map.get(list2[i])+i){
                    ans.add(list2[i]);
                }
            }
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
