package QuestOfTheDay;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        StringBuilder res = new StringBuilder();
        for (int num : list) {
            res.append(String.valueOf(num) + ",");
        }
        return new String(res);
    }

    public void preorder(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) preorder(root.left, list);
        if (root.right != null) preorder(root.right, list);
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nums = data.split(",");
        Deque<Integer> queue = new LinkedList<>();
        for (String _num : nums) {
            queue.addLast(Integer.parseInt(_num));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, queue);
    }

    public TreeNode construct(int low, int upper, Deque<Integer> queue) {
        if (queue.isEmpty() || queue.peekFirst() < low || queue.peekFirst() > upper) return null;
        int val = queue.pollFirst();
        TreeNode cur = new TreeNode(val);
        cur.left = construct(low, val, queue);
        cur.right = construct(val, upper, queue);
        return cur;
    }

    public static void main(String[] args) {
        String str = "1,2,3,";
        System.out.println(Arrays.toString(str.split(",")));
    }
}
