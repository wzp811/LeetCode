package Coding_Interviews_2th;


import java.util.Deque;
import java.util.LinkedList;

public class No59_1_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums,int k){
        if(k==0||nums.length==0) return new int[0];
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!(dq.isEmpty()||nums[i]<=dq.peekLast())) dq.pollLast();
            dq.add(nums[i]);
            if(i>=k-1){
                ans[i-k+1] = dq.peekFirst();
                if(nums[i-k+1]==dq.peekFirst()) {
                    dq.pollFirst();
                }
            }
        }
        return ans;
    }
}
