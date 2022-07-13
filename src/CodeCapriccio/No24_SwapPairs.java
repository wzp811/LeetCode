package CodeCapriccio;

import Hot100.ListNode;

public class No24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0, head);
        ListNode cur = head;
        ListNode last = res;
        while (cur != null && cur.next != null) {
            ListNode a = cur;
            ListNode b = cur.next;
            last.next = b;
            a.next = b.next;
            b.next = a;
            cur = a.next;
            last = a;
        }

        return res.next;
    }
}
