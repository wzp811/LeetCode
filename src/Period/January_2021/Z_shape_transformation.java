package Period.January_2021;
import java.util.*;

public class Z_shape_transformation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String src = input.nextLine();
        int numRows = input.nextInt();
        int len = src.length();
        int T = 2*numRows-2;
        int num = len/T;
        int rest = len - num * T;
        String res = "";
        for(int i=0;i<num;i++){
            res += src.charAt(T*i);
        }
        if(rest>0){
            res += src.charAt(num*T);
        }
        for(int i=1;i<numRows-1;i++){
            for(int j=0;j<num;j++){
                res += src.charAt(j*T+i);
                res += src.charAt((j+1)*T-i);
            }
            if(rest>i){
                res += src.charAt(num*T+i);
            }
            if(rest>T-i){
                res += src.charAt((num+1)*T-i);
            }
        }
        for(int i=0;i<num;i++){
            res += src.charAt(i*T+numRows-1);
        }
        if(rest>=numRows){
            res += src.charAt((num-1)*T+numRows);
        }
        System.out.println(res);
    }
}
