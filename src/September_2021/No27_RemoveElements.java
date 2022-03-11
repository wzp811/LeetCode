package September_2021;
import java.util.*;

public class No27_RemoveElements {
    public static void main(String[] args) {
        No27_RemoveElements ex = new No27_RemoveElements();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int []arrays = new int [num];
        for(int i=0;i<num;i++){
            arrays[i] = input.nextInt();
        }
        int val = input.nextInt();
        int len = ex.removeElement(arrays,val);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.print(arrays[i]+" ");
        }
    }
    public int removeElement(int []nums,int val){
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
