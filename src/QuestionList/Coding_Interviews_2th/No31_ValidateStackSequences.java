package QuestionList.Coding_Interviews_2th;

import java.util.Stack;

public class No31_ValidateStackSequences {
    public boolean validateStackSequences1(int[] pushed,int[] popped){
        Stack<Integer> stack = new Stack<>();
        return process(0,0,pushed,popped,stack);
    }
    public boolean process(int inindex,int outindex,int[] pushed,int[] popped,Stack<Integer> stack){
        if(!stack.isEmpty()&&stack.peek()==popped[outindex]){
            stack.pop();
            if(process(inindex+1,outindex+1,pushed,popped,stack)) return true;
        }
        stack.push(pushed[inindex-1]);
        stack.push(pushed[inindex]);
        if(process(inindex+1,outindex,pushed,popped,stack)) return true;
        else return false;
    }

    public boolean validateStackSequences(int[] pushed,int[] popped){
        int inindex = 0, outindex = 0;
        Stack<Integer> stack = new Stack<>();
        while(outindex<popped.length){
            if(!stack.isEmpty()&&stack.peek()==popped[outindex]){
                stack.pop();
                outindex++;
                continue;
            }
            if(inindex<pushed.length) stack.push(pushed[inindex]);
            else if(inindex>pushed.length) return false;
            inindex++;
        }
        return true;
    }
}
