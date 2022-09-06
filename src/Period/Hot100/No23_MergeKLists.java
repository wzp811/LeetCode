package Period.Hot100;

public class No23_MergeKLists {
    public ListNode mergeKLists1(ListNode[] lists){
        int len = lists.length;
        if(len==0) return new ListNode();
        int mergedis = 1;
        while(mergedis<len){
            int left = 0;
            int right = left+mergedis;
            while(right<len) {
                ListNode i = lists[left];
                ListNode j = lists[right];
                if(i.val<j.val){
                    lists[left] = i;
                    i = i.next;
                }else{
                    lists[left] = j;
                    j = j.next;
                }
                ListNode cur = lists[left];
                while(i!=null&&j!=null){
                    if(i.val<j.val){
                        cur.next = i;
                        i = i.next;
                    }else{
                        ListNode.display(j);
                        cur.next = j;
                        j = j.next;
                    }
                    cur = cur.next;
                }
                while(i!=null) {
                    cur.next = i;
                    i = i.next;
                    cur = cur.next;
                }
                while(j!=null){
                    cur.next = j;
                    j = j.next;
                    cur = cur.next;
                }
                left = right+mergedis;
                right = left+mergedis;
            }
            mergedis *= 2;
        }
        return lists[0];
    }

    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        if(left==right) return lists[left];
        if(left>right) return null;
        int mid = left+((right-left)>>1);
        return mergeTwoList(merge(lists,left,mid),merge(lists,mid+1,right));
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l2!=null) cur.next = l2;
        else cur.next = l1;
        return res.next;
    }

    public static void main(String[] args) {
        No23_MergeKLists obj = new No23_MergeKLists();
        int[][] nums = new int[][]{{1,4,5},{1,3,4},{2,6}};
        ListNode[] lists = new ListNode[3];
        for(int i=0;i<3;i++) lists[i] = ListNode.create(nums[i]);
        ListNode res = obj.mergeKLists(lists);
        ListNode.display(res);
    }
}
