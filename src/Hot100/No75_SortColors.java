package Hot100;

import java.util.Arrays;

public class No75_SortColors {
    //双指针 交换0和2
    public void sortColors1(int[] nums){
        int l = 0;
        int r = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums,l++,i);
            }else if(nums[i]==2){
                if(i>=r) break;
                swap(nums,i--,r--);
            }
        }
    }
    //双指针 交换0和1
    public void sortColors(int[] nums){
        int p0 = 0;
        int p1 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums,p0,i);
                if(p0==p1) p1++;
                else if(p0<p1) swap(nums,p1++,i);
                p0++;
            }else if(nums[i]==1){
                swap(nums,p1++,i);
            }
        }
    }
    public void swap(int[] nums,int l,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        No75_SortColors obj = new No75_SortColors();
        int[] nums = new int[]{2,0,1};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
