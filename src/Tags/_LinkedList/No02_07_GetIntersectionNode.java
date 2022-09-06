package Tags._LinkedList;

public class No02_07_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a.next;
            b = b.next;
            if(a==null&&b==null) return null;
            if(a==null) a = headB;
            if(b==null) b = headA;
        }
        return a;
    }
}
