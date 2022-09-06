package QuestionList.Coding_Interviews;

import java.util.*;

public class No75_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> res = new LinkedList<>();
        int[] frequency = new int[1001];
        for (int num : arr1) {
            frequency[num]++;
        }
        for (int num : arr2) {
            for (int i = 0; i < frequency[num]; i++) res.add(num);
            frequency[num] = 0;
        }
        for (int i = 0; i < 1001; i++) {
            while (frequency[i] > 0) {
                res.add(i);
                frequency[i]--;
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = res.get(i);
        return arr;
    }
}
