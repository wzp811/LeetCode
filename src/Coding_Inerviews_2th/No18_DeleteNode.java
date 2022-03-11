package Coding_Inerviews_2th;

public class No18_DeleteNode {
    public ListNode deleteNode(ListNode head,int val){
        ListNode thead = new ListNode();
        thead.next = head;
        ListNode cur = thead;
        while(thead.next!=null&&thead.next.val!=val){
            thead = thead.next;
        }
        if(thead.next!=null) thead.next = thead.next.next;
        return cur.next;
    }
}
