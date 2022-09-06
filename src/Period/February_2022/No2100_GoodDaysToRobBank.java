package Period.February_2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No2100_GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security,int time){
        List<Integer> ans = new ArrayList<>();
        if(time==0){
            for(int i=0;i<security.length;i++) ans.add(i);
            return ans;
        }
        Set<Integer> set = new HashSet<>();
        int restLeft = time;
        int restRight = time;
        for(int i=1;i<security.length;i++){
            if(security[i]<=security[i-1]) restLeft--;
            else restLeft = time;
            if(security[security.length-i-1]<=security[security.length-i]) restRight--;
            else restRight = time;
            if(restLeft==0) {
                if (set.contains(i)) ans.add(i);
                else set.add(i);
                restLeft = 1;
            }
            if(restRight==0) {
                if (set.contains(security.length-1-i)) ans.add(security.length-1-i);
                else set.add(security.length-1-i);
                restRight = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No2100_GoodDaysToRobBank obj = new No2100_GoodDaysToRobBank();
//        int[] security = new int[]{5,3,3,3,5,6,2};
//        int[] security = new int[]{1,2,3,4,5,6};
        int[] security = new int[]{1};
        System.out.println(obj.goodDaysToRobBank(security,5));
    }
}
