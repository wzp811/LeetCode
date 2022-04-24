package Coding_Interviews;

import com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDVFactoryImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No67_FindMaximumXOR {
    class Node {
        Node[] child;

        Node() {
            child = new Node[2];
        }
    }

    public int findMaximumXORShit(int[] nums) {
        Node root = new Node();
        for (int i = 0; i < nums.length; i++) {
            int digit = 1 << 31;
            Node cur = root;
            while (digit != 0) {
                System.out.println(digit);
                if ((nums[i] & digit) == 0) {
                    if (root.child[0] == null) root.child[0] = new Node();
                    cur = root.child[0];
                } else {
                    if (root.child[1] == null) root.child[1] = new Node();
                    cur = root.child[1];
                }
                digit >>= 1;
            }
        }
        return process(root.child[0], root.child[1], 1 << 31, true);
    }

    public int process(Node left, Node right, int digit, boolean diff) {
        System.out.println(digit);
        int res = 0;
        if (left == null && right == null) return 0;
        if (left == null) res = Math.max(res, process(right.child[0], right.child[1], digit >>> 1, true));
        if (right == null) res = Math.max(res, process(left.child[0], left.child[1], digit >>> 1, true));
        if (left == null || right == null) return res;
        res = Math.max(res, process(left.child[0], right.child[1], digit >>> 1, true));
        res = Math.max(res, process(left.child[1], right.child[0], digit >>> 1, true));
        res = Math.max(res, process(left.child[0], right.child[0], digit >>> 1, false));
        res = Math.max(res, process(left.child[1], right.child[1], digit >>> 1, false));

        return res + (diff ? digit : 0);
    }

    public void display(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.child[0] != null) {
                    queue.add(cur.child[0]);
                    curList.add(0);
                }
                if (cur.child[1] != null) {
                    queue.add(cur.child[1]);
                    curList.add(1);
                }
            }
            res.add(curList);
        }
        System.out.println(res);
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int digit = 1 << 31;
            Node cur = root;
            while (digit != 0) {
                int index = (nums[i] & digit) == 0 ? 0 : 1;
                if (cur.child[index] == null) cur.child[index] = new Node();
                cur = cur.child[index];
                digit >>>= 1;
            }
            int curRes = 0;
            cur = root;
            digit = 1 << 31;
            while (digit != 0) {
                int curDigit = (nums[i + 1] & digit) == 0 ? 1 : 0;
                if (cur.child[curDigit] != null) {
                    curRes += digit;
                    cur = cur.child[curDigit];
                } else {
                    cur = cur.child[1 ^ curDigit];
                }
                digit >>>= 1;
            }
            res = Math.max(res, curRes);
        }
        return res;
    }
}
