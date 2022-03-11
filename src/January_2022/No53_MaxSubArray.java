package January_2022;

public class No53_MaxSubArray {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int cur = 0;
        for(int i=0;i<nums.length;i++){
            cur += nums[i];
            if(cur>max) max = cur;
            if(cur<0) cur = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        No53_MaxSubArray obj = new No53_MaxSubArray();
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(obj.maxSubArray(nums));
    }
}
