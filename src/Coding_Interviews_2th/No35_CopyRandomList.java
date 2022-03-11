package Coding_Interviews_2th;

import java.util.HashMap;

public class No35_CopyRandomList {
    public Node copyRandomList1(Node head){
        Node ans = new Node();
        Node prev = ans;
        HashMap<Node,Node> map = new HashMap<>();
        Node ori = head;
        while(head!=null){
            Node cur = new Node(head.val);
            prev.next = cur;
            map.put(head,cur);
            prev = prev.next;
            head = head.next;
        }
        prev = ans.next;
        while(ori!=null){
            if(ori.random==null) prev.random = null;
            else prev.random = map.get(ori.random);
            ori = ori.next;
            prev = prev.next;
        }
        return ans.next;
    }
    HashMap<Node,Node> assist = new HashMap<>();
    public Node copyRandomList(Node head){
        if(head==null) return null;
        if(!assist.containsKey(head)){
            Node cur = new Node(head.val);
            assist.put(head,cur);
            cur.next = copyRandomList(head.next);
            cur.random = copyRandomList(head.random);
        }
        return assist.get(head);
    }
}
