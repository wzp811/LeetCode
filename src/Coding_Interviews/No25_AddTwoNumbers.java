package Coding_Interviews;

public class No25_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = reverseList(l1), tmp2 = reverseList(l2);
        l1 = tmp1;
        l2 = tmp2;
        ListNode res = new ListNode();
        ListNode resCpy = res;
        int last = 0;
        while (l1 != null || l2 != null) {
            int cur = 0;
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }
            cur += last;
            if (cur >= 10) {
                cur -= 10;
                last = 1;
            } else {
                last = 0;
            }
            ListNode tmp = new ListNode(cur);
            res.next = tmp;
            res = tmp;
        }
        if (last == 1) {
            ListNode tmp = new ListNode(1);
            res.next = tmp;
        }
        l1 = reverseList(tmp1);
        l2 = reverseList(tmp2);
        return reverseList(resCpy.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode next;
        while (true) {
            next = head.next;
            head.next = last;
            last = head;
            if (next == null) return head;
            head = next;
        }
    }
}
