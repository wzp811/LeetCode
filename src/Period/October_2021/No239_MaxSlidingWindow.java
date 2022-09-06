package Period.October_2021;
import java.util.*;

public class No239_MaxSlidingWindow {
    public static void main(String[] args) {
        No239_MaxSlidingWindow ex = new No239_MaxSlidingWindow();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt();
        }
        int k = input.nextInt();
        for(int i=0;i<nums.length-k+1;i++) System.out.println(ex.maxSlidingWindow(nums,k)[i]);
    }
    public int []maxSlidingWindow(int[]nums,int k){
        Deque<Integer> q = new LinkedList<>();
        int []res = new int[nums.length-k+1];
        int temp = Integer.MIN_VALUE;
        for(int i=0;i<k-1;i++){
            while(!q.isEmpty()&&q.peekLast()<nums[i])   q.pollLast();
            q.addLast(nums[i]);
        }
        for(int i=k-1;i<nums.length;i++){
            while(!q.isEmpty()&&q.peekLast()<nums[i])   q.pollLast();
            q.addLast(nums[i]);
            res[i-k+1] = q.peekFirst();
            if(q.peekFirst()==nums[i-k+1])   q.pollFirst();
        }
        return res;
    }
}
