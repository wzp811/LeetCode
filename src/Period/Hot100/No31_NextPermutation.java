package Period.Hot100;

import java.util.Arrays;

public class No31_NextPermutation {
    public void nextPermutation1(int[] nums){
        int index = nums.length-1;
        while(index>0&&nums[index]<nums[index-1]){
            index--;
        }
        if(index!=0){
            int minIndex = index;
            for(int i=minIndex;i<nums.length;i++){
                if(nums[i]>nums[index-1]&&nums[i]<nums[minIndex]) minIndex = i;
            }
            int tmp = nums[index-1];
            nums[index-1] = nums[minIndex];
            nums[minIndex] = tmp;
        }else{
            for(int i=0;i<nums.length/2;i++){
                int tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
        }
    }

    public void nextPermutation(int[] nums){
        int len = nums.length;
        if(len<2) return;
        int tail = len-1;
        while(tail>0&&nums[tail]<=nums[tail-1]) tail--;
        tail--; //确定要更换的位置 接下来找到在它后面最小的比它大的
        if(tail==-1){
            for(int i=0;i<len/2;i++){
                int tmp = nums[i];
                nums[i] = nums[len-1-i];
                nums[len-1-i] = tmp;
            }
            return;
        }
        int head = tail+1;
        int tailval = nums[tail];
        for(int i=tail+1;i<len;i++){
            if(nums[i]>nums[tail]&&nums[head]>=nums[i]) {
                head = i;
            }
            else if(nums[i]<nums[tail]){
                break;
            }
        }
        nums[tail] = nums[head];
        nums[head] = tailval;
        for(int i=0;i<(len-1-tail)/2;i++){
            int tmp = nums[tail+1+i];
            nums[tail+1+i] = nums[len-1-i];
            nums[len-1-i] = tmp;
        }
    }

    public static void main(String[] args) {
        No31_NextPermutation obj = new No31_NextPermutation();
        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{3,2,1};
//        int[] nums = new int[]{1,3,2};
//        int[] nums = new int[]{1,1,5};
//        int[] nums = new int[]{2,3,1};
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
