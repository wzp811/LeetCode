package Period.February_2022;

import java.util.Arrays;

public class No1984_MinimumDifference {
    public int minimumDifference(int[] nums,int k){
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = i+k-1;
        while(j<nums.length){
            min = Math.min(min,nums[j++]-nums[i++]);
        }
        return min;
    }

    public static void main(String[] args) {
        No1984_MinimumDifference obj = new No1984_MinimumDifference();
        int[] nums = new int[]{9,4,1,7};
        System.out.println(obj.minimumDifference(nums,2));
    }
}
