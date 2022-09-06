package Period.Hot100;

import java.util.Arrays;

public class No34_SearchRange {
    public int[] searchRange(int[] nums,int target){
        if (nums.length==0) return new int[]{-1,-1};
        int l = search(nums,target);
        int r = search(nums,target+1);
        if(nums[l]!=target) return new int[]{-1,-1};
        return new int[]{l,nums[r]==target?r:r-1};
    }
    public int search(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(l<r){
            mid = l+((r-l)>>1);
            if(nums[mid]<target) l = mid+1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        No34_SearchRange obj = new No34_SearchRange();
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(obj.searchRange(nums,1)));
    }
}
