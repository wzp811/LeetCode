package Tags._LinkedList;

public class No203_RemoveElements {
    public ListNode removeElements(ListNode head,int val){
        ListNode ans = new ListNode(0,head);
        ListNode last = ans, cur = head;
        while(cur!=null){
            if(cur.val!=val){
                last.next = cur;
                last = last.next;
            }
            cur = cur.next;
        }
        return ans.next;
    }
}
