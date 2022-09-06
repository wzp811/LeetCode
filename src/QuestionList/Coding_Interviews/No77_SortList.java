package QuestionList.Coding_Interviews;

public class No77_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode();
        res.next = head;
        ListNode left = null, right = null;
        int distance = 1;
        int len = 0;
        ListNode cur = res;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        while (distance < len) {
            cur = res;
            left = res.next;
            right = left;
            while (true) {
                System.out.println((left != null ? left.val : -999) + " " + (right != null ? right.val : -999));
                for (int i = 0; i < distance && right != null; i++) right = right.next;
                int leftCnt = distance, rightCnt = distance;
                while (leftCnt > 0 && rightCnt > 0 && right != null && left != null) {
                    if (left.val < right.val) {
                        cur.next = left;
                        left = left.next;
                        leftCnt--;
                    } else {
                        cur.next = right;
                        right = right.next;
                        rightCnt--;
                    }
                    cur = cur.next;
                }
                while (leftCnt > 0 && left != null) {
                    cur.next = left;
                    left = left.next;
                    cur = cur.next;
                    leftCnt--;
                }
                while (rightCnt > 0 && right != null) {
                    cur.next = right;
                    right = right.next;
                    cur = cur.next;
                    rightCnt--;
                }
                if (right == null || left == null) break;
                left = right;
            }
            cur.next = null;
            distance *= 2;
        }
        return res.next;
    }
}
