package September_2021;
import java.util.*;

public class No02_07GetIntersectionNode {
    public static void main(String[] args) {
        No02_07GetIntersectionNode ex = new No02_07GetIntersectionNode();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ListNode prev = null;
        ListNode headA = null, headB = null;
        for(int i=0;i<n;i++){
            ListNode node = new ListNode(input.nextInt());
            if(i==0){
                headA = node;
            }else{
                prev.next = node;
            }
            prev = node;
        }
        for(int i=0;i<n;i++){
            ListNode node = new ListNode(input.nextInt());
            if(i==0){
                headB = node;
            }else{
                prev.next = node;
            }
            prev = node;
        }
        ex.display(headA);
        ex.display(headB);
        ex.display(ex.getIntersectionNode(headA,headB));
    }
    public void display(ListNode head){
        ListNode temp = head;
        System.out.print("The list : ");
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA!=null){
            nodeA = nodeA.next;
            lenA++;
        }
        while(nodeB!=null){
            nodeB = nodeB.next;
            lenB++;
        }
        nodeA = headA;
        nodeB = headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                nodeA = nodeA.next;
            }
        }else if(lenA<lenB){
            for(int i=0;i<lenB-lenA;i++){
                nodeB = nodeB.next;
            }
        }
        while(nodeA!=null){
            if(nodeA==nodeB){
                return nodeA;
            }else{
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return null;
    }
}
