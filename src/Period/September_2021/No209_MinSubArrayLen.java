package Period.September_2021;
import java.util.*;

public class No209_MinSubArrayLen {
    public static void main(String[] args) {
        No209_MinSubArrayLen ex = new No209_MinSubArrayLen();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int []arrays = new int [num];
        for(int i=0;i<num;i++){
            arrays[i] = input.nextInt();
        }
        int target = input.nextInt();
        System.out.println(ex.minSubArrayLen(target,arrays));
    }
    public int minSubArrayLen1(int target,int []nums){
        int len = 0;
        int []temp = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i] = 0;
        }
        while(len<=nums.length){
            for(int i=0;i+len<nums.length;i++){
                temp[i] += nums[i+len];
                if(temp[i]>=target){
                    return len+1;
                }
            }
            len++;
        }
        return 0;
    }
    public int minSubArrayLen(int target,int []nums){
        int i = 0;
        int j = i;
        int len = 0;
        int sum = 0;
        while(j<nums.length){
            sum += nums[j++];
            while(sum >= target){
                if(len==0||len>j-i){
                    len = j-i;
                }
                sum -= nums[i++];
            }
        }
        /*
        while(j<nums.length){
            if(sum<target){
                j++;
                if(j>=nums.length) break;
                sum += nums[j];
            }else{
                if(len==0||len>j-i+1){
                    len = j-i+1;
                }
                sum -= nums[i++];
            }
        }
         */
        return len;
    }
}
