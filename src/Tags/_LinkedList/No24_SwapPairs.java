package Tags._LinkedList;

public class No24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = head.next;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            System.out.println(next.val);
            ListNode append;
            if(next==null){
                append = null;
            }else if(next.next == null){
                append = next;
            }else{
                append = next.next;
            }
            cur.next.next = cur;
            cur.next = append;
            cur = next;
        }
        return ans;
    }
}
