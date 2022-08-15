package Y2022.Y2022_August;

public class MyCircularDeque {

    class Node {
        int value;
        Node next;
        Node prev;
        Node() {};
    }

    int capacity;
    int size;
    Node head, tail;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = new Node();
        tail = head;
    }

    public boolean insertFirst(int value) {
        Node node = new Node();
        node.value = value;
        size = 1;
        head = node;
        tail = node;
        return true;
    }

    public boolean insertFront(int value) {
        if (capacity == size) return false;
        if (size == 0) return insertFirst(value);
        size++;
        Node node = new Node();
        node.value = value;
        head.prev = node;
        node.next = head;
        head = node;
        return true;
    }

    public boolean insertLast(int value) {
        if (capacity == size) return false;
        if (size == 0) return insertFirst(value);
        size++;
        Node node = new Node();
        node.value = value;
        tail.next = node;
        node.prev = tail;
        tail = node;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        if (size == 1) {
            tail = null;
            head = null;
        }
        head.next.prev = null;
        head = head.next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        if (size == 1) {
            tail = null;
            head = null;
        }
        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) return -1;
        return head.value;
    }

    public int getRear() {
        if (size == 0) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
