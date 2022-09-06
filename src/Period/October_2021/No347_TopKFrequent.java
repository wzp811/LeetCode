package Period.October_2021;
import java.util.*;
public class No347_TopKFrequent {
    public static void main(String[] args) {
        No347_TopKFrequent ex = new No347_TopKFrequent();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt();
        }
        int k = input.nextInt();
        int []res = ex.topKFrequent(nums,k);
        for(int i=0;i<k;i++){
            System.out.println(res[i]);
        }
    }
    public int[] topKFrequent(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))    map.replace(nums[i],map.get(nums[i])+1);
            else    map.put(nums[i],1);
        }
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        Queue<Map.Entry<Integer,Integer>>q = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        for(Map.Entry<Integer,Integer> entry:entries){
            q.add(entry);
        }
        int []res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = q.peek().getKey();
            q.poll();
        }
        return res;
    }
}
