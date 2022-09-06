package QuestionList.CodeCapriccio;

import Period.Hot100.ListNode;

public class No203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head);
        ListNode last = res;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                last.next = cur.next;
            } else {
                last = cur;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
