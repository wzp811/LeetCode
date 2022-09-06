package Period.September_2021;
import java.util.*;

public class SwordPoint58_ReverseLeftString {
    public static void main(String[] args) {
        SwordPoint58_ReverseLeftString ex = new SwordPoint58_ReverseLeftString();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int k = input.nextInt();
        System.out.println(ex.reverseLeftWords(s,k));
    }
    public String reverseLeftWords(String s,int n){
        int k = n%s.length();
        StringBuilder sb = new StringBuilder(s.substring(k,s.length()));
        sb.append(s.substring(0,k));
        return sb.toString();
    }
}
