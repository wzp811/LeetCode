package Coding_Interviews;

public class No24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode last = null;
        ListNode next = head.next;
        while (true) {
            next = head.next;
            head.next = last;
            last = head;
            if (next == null) return head;
            head = next;
        }
    }
}
