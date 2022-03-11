package February_2022;

import java.util.LinkedList;
import java.util.List;

public class No1414_FindMinFibonacciNumbers {
    public int findMinFibonacciNumbers(int k){
        List<Integer> record = new LinkedList<>();
        int last = 1;
        int cur = 1;
        record.add(last);
        record.add(cur);
        while(cur<=k){
            int tmp = last;
            last = cur;
            cur = cur+tmp;
            record.add(cur);
        }
        int count = 0;
        for(int i=record.size()-1;i>=0;i--){
            if(k>=record.get(i)){
                count++;
                k -= record.get(i);
                if(k==0) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No1414_FindMinFibonacciNumbers obj = new No1414_FindMinFibonacciNumbers();
        System.out.println(obj.findMinFibonacciNumbers(2));
    }
}
