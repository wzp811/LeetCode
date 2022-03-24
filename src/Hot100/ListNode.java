package Hot100;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){this.val = val;this.next = null;}
    public ListNode(int val,ListNode next){this.val = val;this.next = next;}
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
