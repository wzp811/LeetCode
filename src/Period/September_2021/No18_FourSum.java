package Period.September_2021;
import java.util.*;

public class No18_FourSum {
    public static void main(String[] args) {
        No18_FourSum ex = new No18_FourSum();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []nums = new int [n];
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt();
        }
        int target = input.nextInt();
        System.out.println(ex.fourSum(nums,target));
    }
    public List<List<Integer>> fourSum(int []nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length - 1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(right>left&&nums[left]==nums[left+1]) left++;
                        while(right>left&&nums[right]==nums[right-1])   right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
