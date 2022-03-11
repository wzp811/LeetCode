package Coding_Interviews_2th;


import java.util.Stack;

public class No06_ReversePrint {
    public int[] reversePrint(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
