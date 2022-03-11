package Hot100;

public class No148_SortList {
    public ListNode sortList(ListNode head){
        ListNode res = new ListNode();
        ListNode cur = head;
        res.next = head;
        int dis = 1;
        int len = 0;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        while(dis<len){
            cur = res;
            while(cur!=null) cur = merge(cur,dis);
            dis *= 2;
        }

        return res.next;
    }
    public ListNode merge(ListNode head,int len){
        ListNode l = head.next;
        ListNode r = head.next;
        for(int i=0;i<len&&r!=null;i++) r = r.next;
        if(r==null) return null;
        int llen = len, rlen = len;
        while(llen>0&&rlen>0&&l!=null&&r!=null){
            if(l.val<r.val){
                head.next = l;
                l = l.next;
                llen--;
            }else{
                head.next = r;
                r = r.next;
                rlen--;
            }
            head = head.next;
        }
        while(rlen>0&&r!=null){
            head.next = r;
            r = r.next;
            rlen--;
            head = head.next;
        }
        while(llen>0){
            head.next = l;
            l = l.next;
            llen--;
            head = head.next;
            if(llen==0) head.next = r;
        }
//        返回下一个节点的前一个节点，以供下一组进行归并
        return head;
    }

    public static void main(String[] args) {
        No148_SortList obj = new No148_SortList();
        int[]nums = new int[]{4,2,1,3};
        ListNode head = ListNode.create(nums);
        head = obj.sortList(head);
        ListNode.display(head);
    }
}
