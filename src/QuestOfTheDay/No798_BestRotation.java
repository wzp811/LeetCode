package QuestOfTheDay;

import java.util.Arrays;

public class No798_BestRotation {
    public int bestRotation(int[] nums){
        // nums[i] 向左移动 mov[i] 步后值和下标相等
        int[] mov = new int[nums.length];
        int cur = 0;
        // 移动 i 步后下标和值相等的个数
        int[] equ = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            mov[i] = (i+nums.length-nums[i])%nums.length;
            cur += nums[i]<=i?1:0;
        }
        for(int i=0;i<nums.length;i++) equ[mov[i]]++;
        int index = 0;
        int max = cur;
        for(int i=1;i<nums.length;i++) {
            cur = cur - equ[i-1] + 1;
            if(max<cur){
                cur = max;
                index = i;
            }
        }
        System.out.println(Arrays.toString(mov));
        System.out.println(Arrays.toString(equ));
        return index;
    }

    public static void main(String[] args) {
        No798_BestRotation obj = new No798_BestRotation();
        int[] nums = new int[]{4,1,4,0,0};
        System.out.println(obj.bestRotation(nums));
    }
}
