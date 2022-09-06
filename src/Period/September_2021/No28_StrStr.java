package Period.September_2021;
import java.util.*;

public class No28_StrStr {
    public static void main(String[] args) {
        No28_StrStr ex = new No28_StrStr();
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        System.out.println(ex.strStr(s1,s2));
    }
    public int strStr(String haystack,String needle){
        if(needle.length()==0){
            return 0;
        }
        int []next = new int[needle.length()+1];
        getNext(needle,next);
        int i = 0;
        int j = 0;
        while(j<haystack.length()){
            while(i>=0&&needle.charAt(i)!=haystack.charAt(j))   i = next[i];
            i++;
            j++;
            if(i==needle.length()){
                return j - needle.length();
            }
        }
        return -1;
    }
    public void getNext(String s,int next[]){
        int i = 0;
        int j = -1;
        next[0] = -1;
        while(i<s.length()){
            while(j>0&&s.charAt(i)!=s.charAt(j))   j = next[j];
            i++;
            j++;
            next[i] = j;
        }
        for(i=0;i<s.length()+1;i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
    }
}
