package Period.September_2021;
import java.util.*;

public class No459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        No459_RepeatedSubstringPattern ex = new No459_RepeatedSubstringPattern();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        ex.repeatedSubstringPattern(str);
    }
    public boolean repeatedSubstringPattern(String s){
        int []next = new int[s.length()+1];
        int i = 0;
        int j = -1;
        next[i] = j;
        while(i<s.length()){
            while(j>=0&&s.charAt(i)!=s.charAt(j))   j = next[j];
            next[++i] = ++j;
        }
        for(i=0;i<s.length()+1;i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
        return true;
    }
}
