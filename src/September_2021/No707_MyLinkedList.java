package September_2021;
import java.util.*;

public class No707_MyLinkedList {

    Node head = null;
    int len = 0;

    /** Initialize your data structure here. */
    public No707_MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=len){
            return -1;
        }
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val,head);
        head = node;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<=0){
            addAtHead(val);
            return;
        }else if(index==len){
            addAtTail(val);
            return;
        }else if(index>len){
            return;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        len++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=len){
            return;
        }else if(index==0){
            head = head.next;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        len--;
    }

    public void display(){
        Node temp = head;
        System.out.print("The list is : ");
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node{
        int val;
        Node next = null;
        Node(){}
        Node(int val){this.val = val;}
        Node(int val,Node node){this.val = val; this.next = node;}
    }

    public void test(){
        addAtHead(7);
        display();
        addAtHead(2);
        display();
        addAtHead(1);
        display();
        addAtIndex(3,0);
        display();
        deleteAtIndex(2);
        display();
        addAtHead(6);
        display();
        addAtTail(4);
        display();
        System.out.println(get(4));
        addAtHead(4);
        display();
        addAtIndex(5,0);
        display();
        addAtHead(6);
        display();
    }

    public void test1() {
        No707_MyLinkedList linkedList = new No707_MyLinkedList();
        linkedList.display();
        linkedList.addAtHead(1);
        linkedList.display();
        linkedList.addAtTail(3);
        linkedList.display();
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.display();
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.display();
        System.out.println(linkedList.get(1));            //返回3
    }

    public static void main(String[] args) {
        No707_MyLinkedList linkedList = new No707_MyLinkedList();
        linkedList.test();
    }
}
