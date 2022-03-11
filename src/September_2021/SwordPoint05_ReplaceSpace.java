package September_2021;
import java.util.*;

public class SwordPoint05_ReplaceSpace {
    public static void main(String[] args) {
        SwordPoint05_ReplaceSpace ex = new SwordPoint05_ReplaceSpace();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(ex.replaceSpace(s));
    }
    public String replaceSpace(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                count++;
            }
        }
        char []ch = new char[s.length()+count*2];
        char []str = s.toCharArray();
        int i = s.length()+count*2-1;
        int j = s.length()-1;
        while(j>=0){
            if(str[j]!=' '){
                ch[i--] = str[j];
            }else{
                ch[i--] = '0';
                ch[i--] = '2';
                ch[i--] = '%';
            }
            j--;
        }
        return new String(ch);
    }
}
