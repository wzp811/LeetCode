package Period.January_2022;

import java.util.Arrays;

public class No1005_LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums,int k){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                if(k>0){
                    sum += -nums[i];
                    k--;
                }else{
                    sum += nums[i];
                }
                min = Math.min(min,-nums[i]);
            }else{
                sum += nums[i];
                min = Math.min(min,nums[i]);
            }
        }
        return (k&1)==1?sum-2*min:sum;
    }

    public static void main(String[] args) {
        No1005_LargestSumAfterKNegations obj = new No1005_LargestSumAfterKNegations();
        int[] nums = new int[]{2,-3,-1,5,-4};
        System.out.println(obj.largestSumAfterKNegations(nums,2));
    }
}
