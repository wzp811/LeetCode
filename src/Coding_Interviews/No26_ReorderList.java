package Coding_Interviews;

public class No26_ReorderList {
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode last = mid;
        ListNode midTmp = mid;
        ListNode next;
        mid = mid.next;
        while (mid != null) {
            next = mid.next;
            mid.next = last;
            last = mid;
            if (next == null) break;
            mid = next;
        }
        // mid == tail
        ListNode left = head, right = mid;
        while (true) {
            ListNode leftNext = left.next, rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            if (right == midTmp) {
                right.next = null;
                break;
            }
            left = leftNext;
            right = rightNext;
        }
        return;
    }
}
