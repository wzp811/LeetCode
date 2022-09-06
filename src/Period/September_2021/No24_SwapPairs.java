package Period.September_2021;
import java.util.*;

public class No24_SwapPairs {
    public static void main(String[] args) {
        No24_SwapPairs ex = new No24_SwapPairs();
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
        ex.display(ex.swapPairs(head));
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
    public ListNode swapPairs(ListNode head){
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }
        ListNode node = head;
        ListNode firstNode = null;
        ListNode lastNode = null;//上一组的尾结点
        Boolean isFirst = true;
        ListNode newHead = head.next;
        while(node!=null){
            ListNode next = node.next;
            if(isFirst){
                if(next!=null){
                    firstNode = node;
                    node.next = next.next;
                }
            }else{
                node.next = firstNode;
                if(lastNode!=null){
                    lastNode.next = node;
                }
                lastNode = firstNode;
            }
            node = next;
            isFirst = !isFirst;
        }
        return newHead;
    }

    public ListNode swapPairs2(ListNode head){
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }
        ListNode node = head;
        Boolean isFirst = true;
        ListNode newHead = head.next;
        ListNode prev = null;
        while(node!=null){
            System.out.println(node.val);
            ListNode next = node.next;
            if(isFirst){
                if(next!=null){
                    System.out.print("--");
                    prev = node;
                    System.out.println(prev.val);
                    node.next = next.next;
                }
            }else{
                node.next = prev;
            }
            node = next;
            isFirst = !isFirst;
        }
        return newHead;
    }
    public ListNode swapPairs1(ListNode head){
        return swap(head,null,true);
    }
    public ListNode swap(ListNode node,ListNode before,Boolean flag){
        if(!flag){   //second node
            ListNode next = node.next;
            node.next = before;
            if(next==null){
                return null;
            }else{
                return swap(next,null,!flag);
            }
        }else{  //first node
            if(node.next!=null){
                ListNode next = node.next;
                node.next = next.next;
                return swap(next,node,!flag);
            }else{
                return node;
            }
        }
    }
}
