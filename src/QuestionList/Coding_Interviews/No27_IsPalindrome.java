package QuestionList.Coding_Interviews;

public class No27_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        if (head.next.next.next == null) return head.val == head.next.next.val;
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
        ListNode left = head, right = mid;
        while (left != right) {
            if (left.val != right.val) return false;
            if (left.next == right) break;
            left = left.next;
            right = right.next;
        }
        last = null;
        while (mid != midTmp) {
            next = mid.next;
            mid.next = last;
            last = mid;
            mid = next;
        }
        return true;
    }
}
