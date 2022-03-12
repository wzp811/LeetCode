# Note

### 递归实现反转链表

* 一直递归节点的next知道最后一个非空节点，返回作为反转后的头节点
* 在递归返回的过程中，当前节点的下一个节点的next值指向自己，以实现反转
* 在递归返回的过程中，再让当前节点的next指向null，以达到最后一个节点指向null的效果

![](resources/8951bc3b8b7eb4da2a46063c1bb96932e7a69910c0a93d973bd8aa5517e59fc8.gif)

````java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}
````

### 删除链表中倒数第N个节点 一次遍历

用一个辅助指针`helper`，先让`helper`走`n`步，然后再让当前指针`cur`从头开始和`helper`一起走。 当`helper`到结尾的时候，`cur`的`next`就是要删除的那个节点。

注意处理特殊情况，当要删除的节点是头节点时，直接返回`head.next`

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper = head;
        for (int i = 0; i < n; i++) helper = helper.next;
        if (helper == null) return head.next;
        ListNode cur = head;
        while (helper.next != null) {
            cur = cur.next;
            helper = helper.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
```