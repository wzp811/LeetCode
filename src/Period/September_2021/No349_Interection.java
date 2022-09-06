package Period.September_2021;
import java.util.*;

public class No349_Interection {
    public static void main(String[] args) {
        No349_Interection ex = new No349_Interection();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int []num1 = new int[n];
        int []num2 = new int[m];
        for(int i=0;i<n;i++){
            num1[i] = input.nextInt();
        }
        for(int i=0;i<m;i++){
            num2[i] = input.nextInt();
        }

    }
    public int[] interection(int []nums1,int []nums2){
        HashSet<Integer> _set = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            if(!_set.contains(nums1[i])){
                _set.add(nums1[i]);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(_set.contains(nums2[i])&&!res.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int []array = new int [res.size()];
        int i = 0;
        for(Integer num: res){
            array[i++] = num;
        }
        return array;
    }
}
