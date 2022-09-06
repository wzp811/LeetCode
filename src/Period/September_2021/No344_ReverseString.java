package Period.September_2021;
import java.util.*;

public class No344_ReverseString {
    public static void main(String[] args) {
        No344_ReverseString ex = new No344_ReverseString();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char []s = str.toCharArray();
        ex.reverseString(s);
        System.out.println(s);
    }
    public void reverseString(char []s){
        char temp;
        int len = s.length;
        for(int i=0;i<len/2;i++){
            temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
    }
}
