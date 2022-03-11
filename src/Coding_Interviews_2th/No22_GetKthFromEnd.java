package Coding_Interviews_2th;

import java.util.Stack;

public class No22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head,int k){
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        if(k>stack.size()||k<=0) return null;
        while(k-->0) stack.pop();
        return stack.pop();
    }

    public ListNode getKthFromEnd1(ListNode head,int k){
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        for(int i=0;i<len-k;i++) head = head.next;
        return head;
    }
}
