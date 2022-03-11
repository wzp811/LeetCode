package September_2021;
import java.util.*;
public class No21_Merge_two_ordered_lists {
    public static void main(String[] args) {
        No21_Merge_two_ordered_lists ex = new No21_Merge_two_ordered_lists();
        Scanner input = new Scanner(System.in);
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode last = null;
        int num1,num2;
        num1 = input.nextInt();
        for(int i=0;i<num1;i++){
            int num = input.nextInt();
            ListNode node = new ListNode(num);
            if(i!=0){
                last.next = node;
                last = last.next;
            }else{
                l1 = node;
                last = node;
            }
        }
        num2 = input.nextInt();
        for(int i=0;i<num2;i++){
            int num = input.nextInt();
            ListNode node = new ListNode(num);
            if(i!=0){
                last.next = node;
                last = last.next;
            }else{
                l2 = node;
                last = node;
            }
        }
        ListNode res = ex.mergeTwoLists(l1,l2);
        for(int i=0;i<num1+num2;i++){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        ListNode result = null;
        ListNode last = null;
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        //循环至一条链表为空，另一条链表的内容可以直接接下去
        while(l1!=null){
            ListNode node;
            if(l1.val<=l2.val){
                node = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(result==null){
                result = node;
                last = result;
            }else{
                last.next = node;
                last = last.next;
            }
            if(l2==null){
                last.next = l1;
                break;
            }
        }
        if(l2!=null){
            last.next = l2;
        }
        return result;
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                return new ListNode(l1.val,mergeTwoLists(l1.next,l2));
            }else{
                return new ListNode(l2.val,mergeTwoLists(l1,l2.next));
            }
        }else if(l1==null&&l2!=null){
            return l2;
        }else if(l1!=null&&l2==null){
            return l1;
        }else{
            return null;
        }
    }
}
class ListNode{
    int val;
    ListNode next = null;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
