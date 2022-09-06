package Tags._LinkedList;

public class No206_ReverseList {
//    public ListNode reverseListIteration(ListNode head){
//        if(head==null||head.next==null) return head;
//        ListNode last = head;
//        last.next = null;
//        head = head.next;
//        ListNode next = head.next;
//        while(next!=null){
//            head.next = last;
//            last = head;
//            head = next;
//            next = head.next;
//        }
//        head.next = last;
//        return head;
//    }
//
//    public ListNode reverseList(ListNode head){
//        if(head.next==null) return head;
//        ListNode ans = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return ans;
//    }


    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        ListNode last = null;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        head.next = last;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = reverseList(head.next);
        head.next.next = head;
        // 以达到原来的头节点的next指向null
        head.next = null;
        return ans;
    }

}

