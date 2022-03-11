package Coding_Inerviews_2th;

import java.util.Stack;

public class No51_ReversePairs {
    public int reversePairs1(int[] nums){
        int[] cnt = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<nums.length;i++){
            while(!(stack.isEmpty()||nums[stack.peek()]>nums[i])){
                stack.pop();
            }
            cnt[i] = stack.isEmpty()?0:cnt[stack.peek()]+1;
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++) ans += cnt[i];
        return ans;
    }

    int[] cpy;
    public int reversePairs(int[] nums){
        cpy = new int[nums.length];
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int[] nums,int left,int right){
        if(left>=right) return 0;
        int middle = left+((right-left)>>1);
        int ans = mergeSort(nums,left,middle)+mergeSort(nums,middle+1,right);
        for(int i=left;i<=right;i++) cpy[i] = nums[i];
        int l = left,r = middle+1;
        int index = left;
        while(l<=middle&&r<=right){
            if(cpy[l]>cpy[r]){
                nums[index] = cpy[l];
                ans += middle-l+1;
                l++;
            }else{
                nums[index] = cpy[r];
                r++;
            }
            index++;
        }
        while(l<=middle) nums[index++] = cpy[l++];
        while(r<=right) nums[index++] = cpy[r++];
        return ans;
    }
}
