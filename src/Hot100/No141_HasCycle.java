package Hot100;

public class No141_HasCycle {
    public boolean hasCycle1(ListNode head){
        if(head==null||head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;
        slow = slow.next;
        while(fast!=null&&fast.next!=null&&slow!=null){
            if(fast==slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    public boolean hasCycle(ListNode head){
        if(head==null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow){
            if(fast==null||fast.next==null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
