package _LinkedList;

public class No25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode last = null;
        ListNode next = null;
        ListNode ans = null;
        ListNode cur = head;
        ListNode hair = null;
        ListNode hairCpy = null;
        while(cur!=null){
            ListNode tmp = cur;
            last = null;
            for(int i=0;i<k;i++){
                if(tmp==null){
                    if(ans==null) return head;
                    hair.next = cur;
                    return ans;
                }
                tmp = tmp.next;
            }
            for(int i=0;i<k;i++){
                next = cur.next;
                if(i==0) {
                    hairCpy = cur;
                }else if(i==k-1){
                    if(hair!=null) hair.next = cur;
                    if(ans==null) ans = cur;
                    hair = hairCpy;
                }
                cur.next = last;
                last = cur;
                cur = next;
            }
        }
        return ans;
    }
}
