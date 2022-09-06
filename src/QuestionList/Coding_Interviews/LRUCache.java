package QuestionList.Coding_Interviews;

import java.util.HashMap;

public class LRUCache {
    class ListNode {
        int key, val;
        ListNode next;
        ListNode prev;
        ListNode() {}
    }
    HashMap<Integer, ListNode> map;
    int capacity;
    ListNode head, tail;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode();
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        refresh(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            refresh(node);
        } else {
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            add(node);
            map.put(key, node);
            if (size == capacity) {
                delete();
            } else {
                size++;
            }
        }
    }

    public void refresh(ListNode node) {
        if (head.next == node) return;
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        if (node.next != null) node.next.prev = node;
    }

    public void add(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        if (node.next == null) tail = node;
        else node.next.prev = node;
    }

    public void delete() {
        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
    }
}
