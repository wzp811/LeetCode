package _LinkedList;

public class No142_DetectCycle {
    public ListNode detectCycle(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow!=fast){
            slow = slow.next;
            if(fast==null||fast.next==null) return null;
            fast = fast.next.next;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
