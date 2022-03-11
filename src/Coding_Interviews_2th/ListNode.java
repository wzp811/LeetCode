package Coding_Interviews_2th;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;this.next = null;}
    ListNode(int val, ListNode next){this.val = val;this.next = next;}
    public static ListNode create(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for(int i=1;i<nums.length;i++){
            ListNode tmp = new ListNode(nums[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        return head;
    }
    public static void display(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
