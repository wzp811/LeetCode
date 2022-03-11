package Coding_Interviews_2th;

public class No56_2_SingleNumber {
    public int singleNumber(int[] nums){
       int one = 0, two = 0;
       for(int num : nums){
        one = one^num & ~two;
        two = two^num & ~one;
       }
       return one;
    }
}
