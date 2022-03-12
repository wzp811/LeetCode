package _LinkedList;

public class No19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode helper = head;
        for(int i=0;i<n;i++) helper = helper.next;
        if(helper==null) return head.next;
        ListNode cur = head;
        while(helper.next!=null){
            cur = cur.next;
            helper = helper.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
