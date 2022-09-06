package QuestionList.CodeCapriccio;

import Period.Hot100.ListNode;

public class No19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode fast = res;
        for (int i = 0; i < n; i++) fast = fast.next;
        ListNode cur = res;
        while (fast.next != null) {
            cur = cur.next;
            fast = fast.next;
        }
        cur.next = cur.next.next;
        return res.next;
    }
}
