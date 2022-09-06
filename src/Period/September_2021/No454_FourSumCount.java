package Period.September_2021;
import java.util.*;

public class No454_FourSumCount {
    public static void main(String[] args) {
        No454_FourSumCount ex = new No454_FourSumCount();
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int []A = new int[len];
        int []B = new int[len];
        int []C = new int[len];
        int []D = new int[len];
        for(int i=0;i<len;i++){
            A[i] = input.nextInt();
        }
        for(int i=0;i<len;i++){
            B[i] = input.nextInt();
        }
        for(int i=0;i<len;i++){
            C[i] = input.nextInt();
        }
        for(int i=0;i<len;i++){
            D[i] = input.nextInt();
        }
        System.out.println(ex.fourSumCount(A,B,C,D));
    }
    public int fourSumCount(int []nums1,int []nums2,int []nums3,int []nums4){
        HashMap<Integer,Integer> _map = new HashMap<Integer,Integer>();
        int len = nums1.length;
        int res = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int sum = nums1[i]+nums2[j];
                if(_map.containsKey(sum)){
                    _map.put(sum,_map.get(sum)+1);
                }else{
                    _map.put(sum,1);
                }
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int sum = nums3[i]+nums4[j];
                if(_map.containsKey(0-sum)){
                    res += _map.get(0-sum);
                }
            }
        }
        return res;
    }
}
