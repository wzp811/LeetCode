package September_2021;
import java.util.*;

public class No202_HappyNumber {
    public static void main(String[] args) {
        No202_HappyNumber ex = new No202_HappyNumber();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(ex.isHappy(num));
    }
    public boolean isHappy(int n){
        HashSet<Integer> _set = new HashSet<Integer>();
        while(!_set.contains(n)){
            _set.add(n);
            int newNum = 0;
            while(n!=0){
                newNum += (n%10)*(n%10);
                n /= 10;
            }
            if(newNum==1){
                return true;
            }
            n = newNum;
        }
        return false;
    }
}
