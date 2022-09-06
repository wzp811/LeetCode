package QuestionList.Coding_Interviews_2th;

public class No25_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode cur = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return head.next;
    }
}
