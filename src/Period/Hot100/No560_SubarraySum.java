package Period.Hot100;

import java.util.HashMap;

public class No560_SubarraySum {
//    滑动窗口枚举
    public int subarraySum1(int[] nums,int k){
        int cur = 0;
        int count = 0;
        for(int i=1;i<=nums.length;i++){
            cur = 0;
            for(int j=0;j<i;j++) cur += nums[j];
            if(cur==k) count++;
            for(int j=0;j<nums.length-i;j++){
                cur -= nums[j];
                cur += nums[j+i];
                if(cur==k) count++;
            }
        }
        return count;
    }
    public int subarraySum(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int cur = 0;
        int count = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            cur += nums[i];
            if(map.containsKey(cur-k)){
                count += map.get(cur-k);
            }
            int cnt = map.getOrDefault(cur,new Integer(0));
            cnt++;
            map.put(cur,cnt);
        }
        return count;
    }
}
