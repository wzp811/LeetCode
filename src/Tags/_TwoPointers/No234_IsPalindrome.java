package Tags._TwoPointers;

import Period.Hot100.ListNode;

public class No234_IsPalindrome {
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) return true;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode last = slow;
        ListNode rightHead = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = last;
            last = slow;
            if (next == null) rightHead = slow;
            slow = next;
        }
        ListNode left = head, right = rightHead;
        boolean ans = true;
        if (left.val != right.val) ans = false;
        last = null;
        while (left != right && left.next != right) {
            left = left.next;
            ListNode next = right.next;
            right.next = last;
            last = right;
            right = next;
            if (left.val != right.val) ans = false;
        }

        return ans;
    }
}
