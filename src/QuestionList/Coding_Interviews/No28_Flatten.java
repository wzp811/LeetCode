package QuestionList.Coding_Interviews;

public class No28_Flatten {
    Node last = null;

    public Node flatten(Node head) {
        return process(head);
    }

    public Node process(Node head) {
        Node res = head;
        if (head == null) return null;
        Node child = head.child;
        Node next = head.next;
        if (last == null) {
            head.prev = last;
        } else {
            head.prev = last;
            last.next = head;
        }
        last = head;
        if (child != null) {
            Node tmp = process(child);
            head.child = null;
            tmp.child = null;
            head = tmp;
        }
        if (next != null) {
            Node tmp = process(next);
            head.child = null;
            tmp.child = null;
        }
        return res;
    }
}
