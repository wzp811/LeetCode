package Coding_Interviews_2th;

public class No11_MinArray {
    public int minArray(int[] numbers){
        int l = 0, r = numbers.length-1;
        int mid;
        while(l<r){
            mid = l+((r-l)>>1);
            // 只要右边比中间大，右边一定有序
            if(numbers[r]>numbers[mid]) r = mid;
            // 只有右边比中间小，左边一定有序
            else if(numbers[r]<numbers[mid]) l = mid+1;
            else r--;
        }
        return numbers[l];
    }
}
