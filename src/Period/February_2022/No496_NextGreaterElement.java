package Period.February_2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class No496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1,int[] nums2){
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums1.length;i++) map.put(nums1[i],i);
        for(int i=0;i<nums2.length;i++){
            while(!(stack.isEmpty()||stack.peek()>=nums2[i])){
                int tmp = stack.pop();
                if(map.containsKey(tmp)) res[map.get(tmp)] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        No496_NextGreaterElement obj = new No496_NextGreaterElement();
//        int[] nums1 = new int[]{4,1,2};
//        int[] nums2 = new int[]{1,3,4,2};
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1,nums2)));
    }
}
