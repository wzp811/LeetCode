package Period.January_2022;

import java.util.Stack;

public class No1047_RemoveDuplicates {
    public String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.empty()&&s.charAt(i)==stack.peek()){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        int len = stack.size();
        char[] resArr = new char[len];
        for(int i=len-1;i>=0;i--){
            resArr[i] = stack.pop();
        }
        return String.valueOf(resArr);
    }
    public static void main(String []args){
        String s = "abbaca";
        No1047_RemoveDuplicates obj = new No1047_RemoveDuplicates();
        System.out.println(obj.removeDuplicates(s));
    }
}
