package Tags._HashMap;

import java.util.HashMap;
import java.util.Map;

public class No454_FourSumCount {
    public int fourSumCount(int[] nums1,int[] nums2,int[] nums3,int[] nums4){
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                if(map.containsKey(-nums3[i]-nums4[j])) ans += map.get(-nums3[i]-nums4[j]);
            }
        }
        return ans;
    }
}
