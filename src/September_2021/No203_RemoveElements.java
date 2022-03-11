package September_2021;
import java.util.*;

public class No203_RemoveElements {
    public static void main(String[] args) {
        No203_RemoveElements ex = new No203_RemoveElements();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        ListNode head = null;
        ListNode last = head;
        for(int i=0;i<num;i++){
            ListNode temp = new ListNode(input.nextInt());
            if(i!=0){
                last.next = temp;
                last = temp;
            }else{
                head = temp;
                last = head;
            }
        }
        int val = input.nextInt();
        ListNode res = ex.removeElements(head,val);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode removeElements(ListNode head,int val){
        ListNode res = new ListNode(-1,head);
        ListNode result = res;
        ListNode last = res;
        res = res.next;
        while(res!=null){
            if(res.val==val){
                last.next = res.next;
            }else{
                last = res;
            }
            res = res.next;
        }
        return result.next;
    }
}
