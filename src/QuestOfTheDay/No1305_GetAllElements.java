package QuestOfTheDay;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No1305_GetAllElements {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        if (root1 != null) {
            stack.push(root1);
            cur = root1.left;
        }
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list1.add(cur.val);
                cur = cur.right;
            }
        }
        if (root2 != null) {
            stack.push(root2);
            cur = root2.left;
        }
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list2.add(cur.val);
                cur = cur.right;
            }
        }
        List<Integer> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i++));
        }
        while (j < list2.size()) {
            res.add(list2.get(j++));
        }
        return res;
    }
}
