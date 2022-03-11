package September_2021;

import java.util.Scanner;

public class No142_DetectCycle2 {
    public static void main(String[] args) {
        No142_DetectCycle2 ex = new No142_DetectCycle2();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ListNode head = null;
        ListNode begin = null;
        ListNode prev = null;
        for(int i=0;i<n;i++){
            ListNode node = new ListNode(input.nextInt());
            if(i==0){
                head = node;
            }else{
                prev.next = node;
            }
        }
        ex.display(head);
        ex.display(ex.detectCycle(head));
    }

    private ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while(true){
            if(slow==null||slow.next==null||fast.next==null||fast.next.next==null){
                return null;
            }else{
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    meet = slow;
                    break;
                }
            }
        }
        ListNode node = head;
        while(meet!=node){
            node = node.next;
            meet = meet.next;
        }
        return meet;
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
}
