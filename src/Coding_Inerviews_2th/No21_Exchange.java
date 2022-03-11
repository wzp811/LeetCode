package Coding_Inerviews_2th;

public class No21_Exchange {
    public int[] exchange(int[] nums){
        int left = -1;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                left++;
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
            }
        }
        return nums;
    }
}
