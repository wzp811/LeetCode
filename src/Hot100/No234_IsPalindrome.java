package Hot100;

import java.util.Stack;

public class No234_IsPalindrome {
    public boolean isPalindrome(ListNode head){
        if(head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
//        后半部分开头就是slow.next
        ListNode next = slow.next;
        ListNode tmp = slow.next;
        while(tmp!=null){
            next = next.next;
            tmp.next = slow;
            slow = tmp;
            tmp = next;
        }
        tmp = null;
        next = slow;
        fast = head;
        while(slow!=fast){
            if(slow.val!=fast.val) return false;
            if(slow.next==fast) break;
            slow = slow.next;
            next.next = tmp;
            tmp = next;
            next = slow;
            fast = fast.next;
        }

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

        return true;
    }
}
