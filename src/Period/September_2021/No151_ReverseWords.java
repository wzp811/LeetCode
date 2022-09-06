package Period.September_2021;
import java.util.*;

public class No151_ReverseWords {
    public static void main(String[] args) {
        No151_ReverseWords ex = new No151_ReverseWords();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(ex.reverseWords(s));
    }
    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        //消除无效空格
        int left = 0, right = s.length()-1;
        while(s.charAt(left)==' ')  left++;
        while(s.charAt(right)==' ') right--;
        int temp = left;
        while(left<=right) {
            if((s.charAt(left)==' '&&s.charAt(left-1)!=' ')||left==right){
                StringBuilder str;
                if(left==right){
                    str = new StringBuilder(s.substring(temp,left+1));
                    sb.append(str.reverse());
                }else{
                    str = new StringBuilder(s.substring(temp,left));
                    sb.append(str.reverse());
                    sb.append(' ');
                    temp = left+1;
                }
            }else if(s.charAt(left)==' '&&s.charAt(left-1)==' '){
                temp++;
            }
            left++;
        }
        return sb.reverse().toString();
    }
}
