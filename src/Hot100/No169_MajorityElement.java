package Hot100;

public class No169_MajorityElement {
    public int majorityElement(int[] nums){
        int cnt = 1;
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur==nums[i]) cnt++;
            else cnt--;
            if(cnt==0) cur = nums[i];
        }
        return cur;
    }
}
