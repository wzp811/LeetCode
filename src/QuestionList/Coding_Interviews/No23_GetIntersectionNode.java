package QuestionList.Coding_Interviews;

public class No23_GetIntersectionNode {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        if (a == b) return a;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == b) return a;
            if (a == null) a = headB;
            if (b == null) b = headA;
        }
        return a;
    }
}
