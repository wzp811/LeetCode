package Coding_Interviews;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class No50_PathSum {
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        process(root, map, targetSum, 0);
        return cnt;
    }
    public void process(TreeNode root, HashMap<Integer, Integer> map, int targetSum, int cur) {
        map.put(cur + root.val, map.getOrDefault(cur + root.val, 0) + 1);
        if (map.containsKey(cur + root.val - targetSum)) cnt += map.get(cur + root.val - targetSum);
        if (root.left != null) {
            process(root.left, map, targetSum, cur + root.val);
        }
        if (root.right != null) {
            process(root.right, map, targetSum, cur + root.val);
        }
        map.put(cur + root.val, map.get(cur + root.val) - 1);
    }
}
