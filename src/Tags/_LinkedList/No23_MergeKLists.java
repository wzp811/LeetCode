package Tags._LinkedList;

public class No23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        else if (lists.length == 1) return lists[0];
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left + 1 == right) {
            return merge(lists[left], lists[right]);
        } else if (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
        } else {
            return lists[left];
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode res = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        ans.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
