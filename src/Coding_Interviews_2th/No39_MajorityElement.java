package Coding_Interviews_2th;

public class No39_MajorityElement {
    public int majorityElement(int[] nums){
        int cnt = 1;
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ans){
                cnt++;
            }else{
                if(cnt==1) ans = nums[i];
                else cnt--;
            }
        }
        return ans;
    }
}
