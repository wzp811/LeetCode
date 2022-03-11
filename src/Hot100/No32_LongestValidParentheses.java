package Hot100;

import java.util.Stack;

public class No32_LongestValidParentheses {
    //自己写的 用了动态规划和栈
    public int longestValidParentheses1(String s){
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int max = 0;
        int[]dp = new int[len];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    int index = stack.pop();
                    dp[i] = (i-index+1)+(index==0?0:dp[index-1]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
    //官方题解的贪心策略
    public int longestValidParentheses2(String s){
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            left += s.charAt(i)=='('?1:0;
            right += s.charAt(i)==')'?1:0;
            if(right==left) max = Math.max(left+right,max);
            else if(right>left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(int i=s.length()-1;i>=0;i--){
            left += s.charAt(i)=='('?1:0;
            right += s.charAt(i)==')'?1:0;
            if(right==left) max = Math.max(left+right,max);
            else if(right<left){
                left = 0;
                right = 0;
            }
        }
        return max;
    }
    //官方题解中的栈
    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else max = Math.max(max,i-stack.peek());

            }
        }
        return max;
    }
    public static void main(String[] args) {
        No32_LongestValidParentheses obj = new No32_LongestValidParentheses();
        System.out.println(obj.longestValidParentheses("(()"));
        System.out.println(obj.longestValidParentheses(")()())"));
        System.out.println(obj.longestValidParentheses(""));
        System.out.println(obj.longestValidParentheses(")()((())"));
        System.out.println(obj.longestValidParentheses("()(()"));
    }
}
