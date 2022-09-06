package Tags._LinkedList;

public class No19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        ListNode helper = res;
        while (cur.next != null) {
            n--;
            if (n < 0) helper = helper.next;
            cur = cur.next;
        }
        helper.next = helper.next.next;
        return res.next;
    }
}
