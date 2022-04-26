package Coding_Interviews;

public class No78_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        while (l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return res.next;
    }
}
