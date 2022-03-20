package _LinkedList;

import java.util.Stack;

public class No143_ReorderList {
    public void reorderListStack(ListNode head) {
        if (head.next == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != stack.peek() && cur.next != stack.peek()) {
            ListNode order = stack.pop();
            ListNode next = cur.next;
            cur.next = order;
            order.next = next;
            cur = next;
        }
        cur = stack.pop();
        cur.next = null;
    }

    public void reorderList(ListNode head) {
        if(head.next==null) return;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode cur = fast;
        ListNode last = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        while(last!=null){
            ListNode hnext = head.next;
            ListNode lnext = last.next;
            head.next = last;
            last.next = hnext;
            last = lnext;
            head = hnext;
        }
    }
}
