package Y2022_July;

public class MyCircularQueue {

    class Node {
        int val;
        Node next;
        Node prev;
        Node() {}
        Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    int capacity;
    int size;
    Node head;

    public MyCircularQueue(int k) {
        this.capacity = k;
        size = 0;
        head = new Node();
        head.next = head;
        head.prev = head;
    }

    public boolean enQueue(int value) {
        if (size == capacity) return false;
        Node node = new Node();
        node.val = value;
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false;
        head.next = head.next.next;
        head.next.prev = head;
        return true;
    }

    public int Front() {
        if (size == 0) return -1;
        return head.next.val;
    }

    public int Rear() {
        if (size == 0) return -1;
        return head.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
