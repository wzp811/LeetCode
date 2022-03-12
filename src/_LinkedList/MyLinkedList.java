package _LinkedList;

public class MyLinkedList {
    Node head;
    int len;
    public MyLinkedList() {
        head = null;
        len = 0;
    }

    public int get(int index) {
        if(index<0||index>=len) return -1;
        Node cur = head;
        for(int i=0;i<index;i++) cur = cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val,head);
        head = node;
        len++;
    }

    public void addAtTail(int val) {
        if(len==0){
            addAtHead(val);
            return;
        }
        Node cur = head;
        Node node = new Node(val);
        while(cur.next!=null) cur = cur.next;
        cur.next = node;
        len++;
    }

    public void addAtIndex(int index, int val) {
        if(index==len){
            addAtTail(val);
        }else if(index>len){
            return;
        }else if(index<=0){
            addAtHead(val);
        }else{
            Node node = new Node(val);
            Node cur = head;
            for(int i=0;i<index-1;i++){
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            len++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=len) return;
        else if(index==0){
            head = head.next;
        }else{
            Node cur = head;
            for(int i=0;i<index-1;i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        len--;
    }

    class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/*
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get","get","deleteAtIndex","deleteAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1],[3],[3],[0],[0],[0],[0]]
["MyLinkedList","addAtTail","get"]
[[],[1],[0]]
["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
["MyLinkedList","addAtHead","deleteAtIndex"]
[[],[1],[0]]
 */

/*
["MyLinkedList","addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex",
"addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead",
"addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead",
"addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead",
"addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail",
"addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex",
"addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex"]
[[],[84],[2],[39],[3],[1],[42],[1,80],
[14],[1],[53],[98],[19],[12],[2],[16],
[33],[4,17],[6,8],[37],[43],[11],[80],
[31],[13,23],[17],[4],[10,0],[21],[73],[22],
[24,37],[14],[97],[8],[6],[17],[50],[28],
[76],[79],[18],[30],[5],[9],[83],[3],
[40],[26],[20,90],[30]]
 */
