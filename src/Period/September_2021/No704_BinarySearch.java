package Period.September_2021;
import java.util.*;

public class No704_BinarySearch {
    public static void main(String[] args) {
        No704_BinarySearch ex = new No704_BinarySearch();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int []arrays = new int [num];
        for(int i=0;i<num;i++){
            arrays[i] = input.nextInt();
        }
        int target = input.nextInt();
        System.out.println(ex.search(arrays,target));
    }
    public int search(int[] nums, int target){
        int res = -1;
        int begin = 0;
        int end = nums.length-1;
        while(begin<=end){
            if(nums[(begin+end)/2]<target){
                begin = (begin+end)/2+1;
            }else if(nums[(begin+end)/2]>target){
                end = (begin+end)/2-1;
            }else{
                res = (begin+end)/2;
                break;
            }
        }
        return res;
    }
}
