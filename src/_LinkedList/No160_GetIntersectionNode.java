package _LinkedList;

public class No160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a.next;
            if (a == null) a = headB;
            b = b.next;
            if (b == null) b = headA;
        }
        return a;
    }
}
