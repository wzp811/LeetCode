package September_2021;
import java.util.*;

public class No1_TwoSum {
    public static void main(String[] args) {
        No1_TwoSum ex = new No1_TwoSum();
        Scanner input = new Scanner(System.in);
    }
    public int [] twoSum1(int nums[],int target){
        HashMap<Integer,Integer> _map = new HashMap<Integer,Integer>();
        int []res = new int [2];
        for(int i=0;i<nums.length;i++){
            if(_map.containsKey(nums[i])&&nums[i]*2==target){
                res[0] = i;
                res[1] = _map.get(nums[i]);
                return res;
            }else{
                _map.put(nums[i],i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(_map.containsKey(target-nums[i])&&i!=_map.get(target-nums[i])){
                res[0] = i;
                res[1] = _map.get(target-nums[i]);
                return res;
            }
        }
        return null;
    }
    public int []twoSum(int nums[],int target){
        HashMap<Integer,Integer> _map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(_map.containsKey(target-nums[i])){
                int []res = new int [2];
                res[0] = i;
                res[1] = _map.get(target-nums[i]);
                return res;
            }else{
                _map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
