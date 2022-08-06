package Y2022.Y2022_July;

public class Skiplist {

    private static int MAX_LEVEL = 32;
    private static double PRIORITY = 0.25;

    Node head;
    int curLevel;

    class Node {
        int value;
        Node[] next;

        Node(int value, int size) {
            this.value = value;
            next = new Node[size];
        }
    }

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        curLevel = 0;
    }

    public boolean search(int target) {
        Node cur = head;
        int l = curLevel;
        while (l >= 0) {
            cur = getClosestNode(cur, l, target);
            if (cur.next[l] != null && cur.next[l].value == target) return true;
            else l--;
        }
        return false;
    }

    public void add(int num) {
        Node cur = head;
        int newLevel = getRandomLevel();
        Node newNode = new Node(num, newLevel + 1);
        curLevel = Math.max(curLevel, newLevel);
        int l = curLevel;
        while (l >= 0) {
            cur = getClosestNode(cur, l, num);
            if (l <= newLevel) {
                newNode.next[l] = cur.next[l];
                cur.next[l] = newNode;
            }
            l--;
        }
    }

    public boolean erase(int num) {
        Node cur = head;
        int l = curLevel;
        boolean res = false;
        while (l >= 0) {
            cur = getClosestNode(cur, l, num);
            if (cur.next[l] != null && cur.next[l].value == num) {
                cur.next[l] = cur.next[l].next[l];
                res = true;
            }
            if (head.next[l] == null) curLevel--;
            l--;
        }
        return res;
    }

    public static int getRandomLevel() {
        int level = 0;
        while (Math.random() < PRIORITY && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public static Node getClosestNode(Node node, int level, int value) {
        while (node.next[level] != null && node.next[level].value < value) {
            node = node.next[level];
        }
        return node;
    }
}
