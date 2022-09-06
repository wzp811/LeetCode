package Period.September_2021;
import java.util.*;

public class No19_RemoveNthFromEnd {
    public static void main(String[] args) {
        No19_RemoveNthFromEnd ex = new No19_RemoveNthFromEnd();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        ListNode head = null;
        ListNode temp = null;
        for(int i=0;i<num;i++){
            ListNode node = new ListNode(input.nextInt());
            if(i==0){
                head = node;
                temp = head;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }
        int n = input.nextInt();
        ex.display(head);
        ex.display(ex.removeNthFromEnd(head,n));
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
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode vhead = new ListNode(-1,head);
        ListNode node = vhead;
        ListNode deleteNode = vhead;
        while(node!=null){
            node = node.next;
            if(n!=-1){
                n--;
            }else{
                deleteNode = deleteNode.next;
            }
        }
        deleteNode.next = deleteNode.next.next;
        return vhead.next;
    }
}
