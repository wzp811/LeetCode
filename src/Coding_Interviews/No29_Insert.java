package Coding_Interviews;

public class No29_Insert {
    public Node insert(Node head, int insertVal) {
        Node res = head;
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node min = head;
        Node max = head;
        Node cur = head.next;
        while (cur != head) {
            if (min.val > cur.val) min = cur;
            if (max.val <= cur.val) max = cur;
            cur = cur.next;
        }
        cur = min;
        Node last = max;
        if (cur.val >= insertVal) {
            node.next = cur;
            last.next = node;
            return head;
        }
        last = cur;
        cur = cur.next;
        while (cur.val < insertVal && cur != min) {
            last = cur;
            cur = cur.next;
        }
        node.next = cur;
        last.next = node;
        return head;
    }
}
