package Period.September_2021;
import java.util.*;

public class No53_MaximumSuborderSum {
    public static void main(String[] args) {
        No53_MaximumSuborderSum ex = new No53_MaximumSuborderSum();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int []array = new int[num];
        for(int i=0;i<num;i++){
            array[i] = input.nextInt();
        }
        System.out.println(ex.maxSubArray(num,array));
    }
    public int maxSubArray(int num,int []array){
        int res = 0;

        return res;
    }
}
