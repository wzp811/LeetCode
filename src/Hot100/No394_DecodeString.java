package Hot100;

import java.util.Stack;

public class No394_DecodeString{
    public String decodeString(String s) {
        StringBuilder sb = process(s,-1,s.length());
        return new String(sb);
    }
    public StringBuilder process(String s,int begin,int end){
        int left = 0;
        int beginIndex = -1;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=begin+1;i<end;i++){
            if(s.charAt(i)=='['){
                if(left==0) beginIndex = i;
                left++;
            }else if(s.charAt(i)==']'){
                left--;
                if(left==0) {
                    StringBuilder cur = process(s, beginIndex, i);
                    while (num > 0) {
                        sb.append(cur);
                        num--;
                    }
                }
            }else if(Character.isLetter(s.charAt(i))&&left==0){
                sb.append(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))&&left==0){
                num *= 10;
                num += (int)s.charAt(i)-'0';
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        No394_DecodeString obj = new No394_DecodeString();
        System.out.println(obj.decodeString("3[a]2[bc]"));
        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
        System.out.println(obj.decodeString("abc3[cd]xyz"));
    }
}
