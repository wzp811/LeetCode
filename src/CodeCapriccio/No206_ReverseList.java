package CodeCapriccio;

import Hot100.ListNode;

public class No206_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
}
