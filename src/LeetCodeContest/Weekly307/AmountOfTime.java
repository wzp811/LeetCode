package LeetCodeContest.Weekly307;

import QuestionList.Coding_Interviews.TreeNode;

import java.util.*;

public class AmountOfTime {
    public int amountOfTime(TreeNode root, int start) {
        if (root.left == null && root.right == null) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            cnt++;
            if (node.left != null) {
                queue.addLast(node.left);
                List<Integer> list = map.getOrDefault(node.val, new ArrayList<>());
                list.add(node.left.val);
                map.put(node.val, list);
                list = map.getOrDefault(node.left.val, new ArrayList<>());
                list.add(node.val);
                map.put(node.left.val, list);
            }
            if (node.right != null) {
                queue.addLast(node.right);
                List<Integer> list = map.getOrDefault(node.val, new ArrayList<>());
                list.add(node.right.val);
                map.put(node.val, list);
                list = map.getOrDefault(node.right.val, new ArrayList<>());
                list.add(node.val);
                map.put(node.right.val, list);
            }
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        Deque<Integer> tqe = new ArrayDeque<>();
        tqe.addLast(start);
        set.add(start);
        while (set.size() < cnt) {
            int size = tqe.size();
            for (int i = 0; i < size; i++) {
                int cur = tqe.pollFirst();
                List<Integer> list = map.get(cur);
                for (int next : list) {
                    if (!set.contains(next)) {
                        tqe.addLast(next);
                        set.add(next);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
