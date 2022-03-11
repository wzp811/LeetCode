package September_2021;
import java.nio.channels.ClosedChannelException;
import java.util.*;

public class No20_ValidParentheses {
    public static void main(String[] args) {
        No20_ValidParentheses ex = new No20_ValidParentheses();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(ex.isValid(s));
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            }
            else {
                if(!stack.empty()&&(s.charAt(i)==')'&&stack.peek()=='(')||(s.charAt(i)==']'&&stack.peek()=='[')||(s.charAt(i)=='}'&&stack.peek()=='{'))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }
}
