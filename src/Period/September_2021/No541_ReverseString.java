package Period.September_2021;
import java.util.*;

public class No541_ReverseString {
    public static void main(String[] args) {
        No541_ReverseString ex = new No541_ReverseString();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int k = input.nextInt();
        System.out.println(ex.reverseStr(str,k));
    }
    public String reverseStr(String s,int k){
        String res = "";
        for(int i=0;i<s.length()/k;i++){
            if(i%2==0){
                for(int j=0;j<k;j++){
                    res += s.charAt((i+1)*k-j-1);
                }
            }else{
                for(int j=0;j<k;j++){
                    res += s.charAt(i*k+j);
                }
            }
        }
        if(s.length()/k%2!=0){
            for(int i=s.length()/k*k;i<s.length();i++){
                res += s.charAt(i);
            }
        }else{
            for(int i=0;i<s.length()-s.length()/k*k;i++){
                res += s.charAt(s.length()-i-1);
            }
        }
        return res;
    }

    public String reverseStr1(String s,int k){
        int count = 0;
        String res = "";
        if(s.length()<k){
            for(int i=0;i<s.length();i++){
                res += s.charAt(s.length()-1-i);
            }
            return res;
        }else if(s.length()>=k&&s.length()<2*k){
            for(int i=0;i<k;i++){
                res += s.charAt(k-1-i);
            }
            for(int i=k;i<s.length();i++){
                res += s.charAt(i);
            }
            return res;
        }
        for(int i=0;i<s.length();i++){
            count++;
            if(count==k*2){
                for(int j=0;j<k;j++){
                    res += s.charAt(i-j-k);
                }
                for(int j=0;j<k;j++){
                    res += s.charAt(i-k+j+1);
                }
                count = 0;
                if(s.length()-i-1<k){
                    for(int j=0;j<s.length()-i-1;j++){
                        res += s.charAt(i+j+1);
                    }
                    break;
                }else if(s.length()-i-1>=k&&s.length()-i-1<k*2){
                    for(int j=0;j<k;j++){
                        res += s.charAt(i+k-j);
                    }
                    for(int j=0;j<s.length()-i-k-1;j++){
                        res += s.charAt(i+k+j+1);
                    }
                    break;
                }
            }
        }
        return res;
    }
    public String reverseStr2(String s,int k){
        char []ch = s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            int left = i;
            int right = Math.min(s.length()-1,left+k-1);
            while(left<right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
            }
        }
        return new String(ch);
    }
}
