package CodeCapriccio;

public class MyLinkedList {

    class Node {
        int val;
        Node next;
        Node prev;
        Node () {}
        Node (int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        Node (int val, Node next) {
            this.val = val;
            this.next = next;
            this.prev = null;
        }
        Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    int len;

    public MyLinkedList() {
        head = new Node();
        len = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= len) return -1;
        Node cur = head.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        display();
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        len++;
        display();
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node cur = head;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        cur.next = node;
        len++;
        display();
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > len) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == len) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            len++;
        }
        display();
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        len--;
        display();
    }

    public void display() {
        Node node = head.next;
        System.out.print("list : ");
        for (int i = 0; i < len; i++) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
