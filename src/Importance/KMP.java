package Importance;
import java.util.*;

public class KMP {

    /*
    例子
    bcbcbcbcbea
    bcbcbea
     */


    public static void main(String[] args) {
        KMP ex = new KMP();
        Scanner input = new Scanner(System.in);
        String haystack = input.nextLine();
        String needle = input.nextLine();
        System.out.println(ex.kmp1(haystack,needle));
    }

    //无前置空 即next.length()==s.length();
    public void getNext(String s,int next[]){
        int i = 0;
        int j = -1;
        next[i] = j;
        while(i<s.length()-1){
            i++;
            j++;
            while(j>=0&&s.charAt(i)!=s.charAt(j))
                j = next[j];
            next[i] = j;
        }
        for(i=0;i<s.length();i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
        /*
        next数组
        b   c   b   c   b   e   a
        -1  -1  0   1   2   -1  -1
         */
    }
    public int kmp(String haystack,String needle){
        int []next = new int[needle.length()];
        getNext(needle,next);
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            while(j>=0&&haystack.charAt(i)!=needle.charAt(j)) {
                if(j==0)    i++;
                else    j = next[j-1]+1;
                //以上代码仍有问题 当haystack[0]!=needle[0]时有bug
            }
            i++;
            j++;
            if(j==needle.length())  return i-needle.length();
        }
        return -1;
    }

    //有前置空
    void getNext1(String s,int []next){
        int i = 0;
        int j = -1;
        next[i] = j;
        while(i<s.length()){
            while(j>=0&&s.charAt(i)!=s.charAt(j))   j = next[j];
            next[++i] = ++j;
        }
        for(i=0;i<=s.length();i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
        /*
        next数组
            b   c   b   c   b   e   a
        -1  0   0   1   2   3   0   0
         */
    }
    public int kmp1(String haystack,String needle){
        if (needle.length()==0) return 0;
        int []next = new int[needle.length()+1];
        getNext1(needle,next);
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            while(j>=0&&haystack.charAt(i)!=needle.charAt(j))   j = next[j];
            i++;
            j++;
            if(j==needle.length()){
                return i-needle.length();
            }
        }
        return -1;
    }
}
