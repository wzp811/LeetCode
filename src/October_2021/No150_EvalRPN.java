package October_2021;
import java.util.*;

public class No150_EvalRPN {
    public static void main(String[] args) {
        No150_EvalRPN ex = new No150_EvalRPN();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String []tokens = new String[n];
        for(int i=0;i<n;i++){
            tokens[i] = input.nextLine();
        }
        System.out.println(ex.evalRPN(tokens));
    }
    public int evalRPN(String []tokens){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1+n2);
            }else if(tokens[i].equals("-")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2-n1);
            }else if(tokens[i].equals("*")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1*n2);
            }else if(tokens[i].equals("/")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2/n1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
