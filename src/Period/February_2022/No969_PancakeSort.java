package Period.February_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No969_PancakeSort {
    public List<Integer> pancakeSort(int[] arr){
        List<Integer> res = new LinkedList<>();
        int r = arr.length-1;
        while(r!=0){
            int maxIndex = 0;
            for(int i=1;i<=r;i++) maxIndex = arr[i]>arr[maxIndex]?i:maxIndex;
            if(maxIndex!=r){
                int tmp = arr[maxIndex];
                for(int i=maxIndex;i<r;i++) arr[i] = arr[i+1];
                arr[r] = tmp;
                if(maxIndex+1>1) res.add(maxIndex+1);
                if(r+1>1) res.add(r+1);
                if(r>1) res.add(r);
                if(maxIndex>1) res.add(maxIndex);
            }
            System.out.println(maxIndex+" "+ Arrays.toString(arr));
            r--;
        }
        return res;
    }

    public static void main(String[] args) {
        No969_PancakeSort obj = new No969_PancakeSort();
//        int[] arr = new int[]{3,2,4,1};
        int[] arr = new int[]{3,2,1,4};
        System.out.println(obj.pancakeSort(arr));
    }
}
