package Examinations.Tencent;

import Period.Hot100.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        Deque<Integer> queue = new ArrayDeque<>();
        while (a != null) {
            queue.addLast(a.val);
            a = a.next;
        }
        ListNode res = null;

        while (true) {
            if (b == null && queue.isEmpty()) break;
            int num1 = b == null ? 0 : b.val;
            int num2 = queue.isEmpty() ? 0 : queue.pollLast();
            b = b == null ? b : b.next;
            ListNode cur = new ListNode(num1 ^ num2);
            cur.next = res;
            res = cur;
        }
        while (res != null && res.val == 0) res = res.next;
        return res == null ? new ListNode(0) : res;
    }
}
