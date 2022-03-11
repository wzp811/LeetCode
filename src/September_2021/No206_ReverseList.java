package September_2021;
import java.util.*;

public class No206_ReverseList {
    public static void main(String[] args) {
        No206_ReverseList ex = new No206_ReverseList();
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
        ex.display(head);
        ex.display(ex.reverseList2(head));
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
    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        ListNode temp = head;
        ListNode end = null;
        while(temp.next!=null){
            ListNode next = temp.next;
            temp.next = end;
            end = temp;
            temp = next;
        }
        temp.next = end;
        return temp;
    }
    public ListNode reverseList2(ListNode head){
        return reverse(head,null);
    }
    public ListNode reverse(ListNode node, ListNode end){
        if(node==null){
            return null;
        }
        ListNode temp;
        if(node.next!=null){
            temp = node.next;
            node.next = end;
            return reverse(temp,node);
        }else{
            node.next = end;
            return node;
        }
    }
}
