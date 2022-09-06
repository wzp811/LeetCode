package Period.September_2021;
import java.util.*;

public class No977_SortSquare {
    public static void main(String[] args) {
        No977_SortSquare ex = new No977_SortSquare();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int []arrays = new int [num];
        for(int i=0;i<num;i++){
            arrays[i] = input.nextInt();
        }
        int []res = ex.sortedSquares(arrays);
        for(int i=0;i<num;i++){
            System.out.print(res[i]+" ");
        }
    }
    public int[] sortedSquares1(int []nums){
        int []res = new int [nums.length];
        int min = nums[nums.length-1];
        int begin = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                begin = i;
                break;
            }else if(nums[i]>0){
                if(nums[i]<min){
                    min = nums[i];
                    begin = i;
                }
            }else{
                if(-nums[i]<min){
                    min = -nums[i];
                    begin = i;
                }
            }
        }
        int k = 0;
        res[k++] = nums[begin]*nums[begin];
        int i = begin;//negative
        int j = begin;
        while(k<nums.length-1){
            if(-nums[i]>nums[j]){
                res[k++] = nums[j]*nums[j];
                j++;
            }else{
                res[k++] = nums[i]*nums[i];
                i--;
            }
            if(i<0||j>nums.length-1){
                break;
            }
        }
        if(i<0){
            for(;j<nums.length;j++){
                res[k++] = nums[j]*nums[j];
            }
        }else if(j>nums.length-1){
            for(;i>=0;i--){
                res[k++] = nums[i]*nums[i];
            }
        }
        return res;
    }
    public int[] sortedSquares(int []nums){
        int []res = new int [nums.length];
        int i = 0;
        int j = nums.length-1;
        int index = nums.length-1;
        while(i<=j){
            if(nums[i]<0&&-nums[i]>nums[j]){
                res[index--] = nums[i]*nums[i];
                i++;
            }else{
                res[index--] = nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}
