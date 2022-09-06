package Period.September_2021;
import java.util.*;

public class No15_ThreeSum {
    public static void main(String[] args) {
        No15_ThreeSum ex = new No15_ThreeSum();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt();
        }
        System.out.println(ex.threeSum(nums));
    }
    public List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        HashSet<List> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;
        for(int i=0;i<nums.length-2;i++){
            left = i+1;
            right = nums.length - 1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                    if(!set.contains(temp))
                        set.add(temp);
                    left++;
                    right--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> i: set){
            res.add(i);
        }
        return res;
    }
    public List<List<Integer>> threeSum(int []nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        for(int i=0;i<nums.length-2;i++){
            left = i+1;
            right = nums.length - 1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    break;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum2(int []nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }else if(i>0&&nums[i]==nums[i-1]){
                break;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(nums[left]!=nums[left+1]) left++;
                    while(nums[right]!=nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
