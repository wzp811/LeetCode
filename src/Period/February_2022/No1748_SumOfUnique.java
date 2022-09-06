package Period.February_2022;

import java.util.HashMap;

public class No1748_SumOfUnique {
    public int sumOfUnique(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],new Integer(0));
            count++;
            if(count==1) sum += nums[i];
            else if(count==2) sum -= nums[i];
            map.put(nums[i],count);
        }
        return sum;
    }

    public static void main(String[] args) {
        No1748_SumOfUnique obj = new No1748_SumOfUnique();
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(obj.sumOfUnique(nums));
    }
}
