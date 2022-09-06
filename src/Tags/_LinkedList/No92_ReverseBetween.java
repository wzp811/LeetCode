package Tags._LinkedList;

public class No92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode res = new ListNode();
        res.next = head;
        ListNode begin = res;
        for (int i = 0; i < left - 1; i++) {
            begin = begin.next;
        }
        ListNode cur = begin.next;
        ListNode last = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        begin.next.next = cur;
        begin.next = last;
        return res.next;
    }
}
