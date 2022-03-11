package Coding_Interviews_2th;

public class No53_2_MissingNumber {
    public int missingNumber(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+((r-l)>>1);
            if(nums[mid]==mid) l = mid+1;
            else r = mid;
        }
        return nums[l]==l?nums.length-1:l;
    }
}
