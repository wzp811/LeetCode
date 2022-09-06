package QuestionList.Coding_Interviews_2th;

public class Node {
    int val;
    Node next;
    Node random;
    Node(){}
    Node(int val){this.val = val;this.next = null;this.random = null;}
    Node(int val, Node next){this.val = val;this.next = next;}
    public static Node create(int[] nums){
        Node head = new Node(nums[0]);
        Node cur = head;
        for(int i=1;i<nums.length;i++){
            Node tmp = new Node(nums[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        return head;
    }
    public static void display(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
