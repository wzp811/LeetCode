package Hot100;

import java.util.HashSet;

public class No160_GetIntersectionNode {
    public ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode acpy = headA, bcpy = headB;
        if(headA==null||headB==null) return null;
        while(headA!=null&&headB!=null){
            if(headA==headB) return headA;
            headA = headA.next;
            headB = headB.next;
            if(headA==null) headA = bcpy;
            if(headB==null) headB = acpy;
        }
        return null;
    }
}
