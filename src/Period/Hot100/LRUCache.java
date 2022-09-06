package Period.Hot100;

import java.util.HashMap;

public class LRUCache {
    /*
    int size;
    int count;
    ListNode head;
    ListNode tail;
    HashMap<Integer,ListNode> map;
    public LRUCache(int capacity) {
        size = capacity;
        count = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode cur = map.get(key);
        update(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            update(cur);
            map.put(key,cur);
        }else{
            ListNode cur = new ListNode(value,key);
            if(count==size){
                map.remove(tail.index);
                delete();
            }else{
                count++;
            }
            add(cur);
            map.put(key,cur);
        }
    }
    public void update(ListNode cur){
        if(cur==head) return;
        cur.pre.next = cur.next;
        if(cur.next!=null) cur.next.pre = cur.pre;
        else{
            tail = tail.pre;
            tail.next = null;
        }
        cur.next = head;
        head.pre = cur;
        cur.pre = null;
        head = cur;
    }
    public void add(ListNode cur){
        if(head==null){
            head = cur;
            tail = cur;
            return;
        }
        cur.next = head;
        head.pre = cur;
        cur.pre = null;
        head = cur;
    }
    public void delete(){
        if(tail.pre==null){
            head = null;
            tail = null;
        }
        tail = tail.pre;
        tail.next = null;
    }
    class ListNode{
        int val;
        int index;
        ListNode next;
        ListNode pre;
        public ListNode(){}
        public ListNode(int val,int index){this.val = val; this.index = index;}
        public ListNode(int val, ListNode next, ListNode pre){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }
     */

    class ListNode{
        int key,value;
        ListNode pre,next;
        public ListNode(){};
        public ListNode(int key,int value){this.key = key;this.value = value;this.pre = null;this.next = null;}
    }
    int size;
    int count;
    HashMap<Integer,ListNode> map;
    ListNode head,tail;
    public LRUCache(int capacity){
        head = null;
        tail = null;
        size = capacity;
        count = 0;
        map = new HashMap<>();
    }
    public int get(int key){
        if(!map.containsKey(key)) return -1;
        ListNode cur = map.get(key);
        update(cur);
        return cur.value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.value = value;
            update(cur);
        }else{
            ListNode cur = new ListNode(key,value);
            if(count==size) delete();
            else count++;
            add(cur);
            map.put(key,cur);
        }
    }
    public void update(ListNode cur){
        if(cur==head){
            return;
        }else if(cur!=tail){
            cur.next.pre = cur.pre;
        }else if(tail==cur) if(cur.pre!=null) tail = cur.pre;
        cur.pre.next = cur.next;
        cur.next = head;
        cur.pre = null;
        head.pre = cur;
        head = cur;
    }
    public void add(ListNode cur){
        if(head==null){
            head = cur;
            tail = cur;
        }else{
            cur.next = head;
            head.pre = cur;
            head = cur;
        }
    }
    public void delete(){
        map.remove(tail.key);
        if(size==1) {
            head = null;
            tail = null;
            return;
        }
        tail.pre.next = null;
        tail = tail.pre;
    }
}
