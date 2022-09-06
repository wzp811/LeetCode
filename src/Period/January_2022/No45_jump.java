package Period.January_2022;

import java.util.LinkedList;
import java.util.Queue;

public class No45_jump {
    public int jump(int[] nums){
        int count = 0;
        if (nums.length==1) return count;
        Queue<Integer> queue = new LinkedList<>();
        int cur = 0;
        int rightest = 0;
        queue.add(cur);
        while(rightest<nums.length-1){
            count++;
            int righttmp = rightest;
            for(int i=cur;i<=righttmp;i++){
                rightest = Math.max(i+nums[i],rightest);
            }
            cur = righttmp+1;
        }
        return count;
    }

    public static void main(String[] args) {
        No45_jump obj = new No45_jump();
        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{2,3,0,1,4};
//        int[] nums = new int[]{1,2};
        System.out.println(obj.jump(nums));
    }
}
