package Y2022.Y2022_August;

import QuestionList.Coding_Interviews.TreeNode;

import java.util.*;

public class No655_PrintTree {
    int height = -1;
    public List<List<String>> printTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
            height++;
        }
        int m = height + 1;
        int n = (int) (Math.pow(2, height + 1) - 1);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(matrix[i], -100);
        func(root, matrix, 0, (n - 1) / 2);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -100) list.add("");
                else list.add(String.valueOf(matrix[i][j]));
            }
            res.add(list);
        }
        return res;
    }
    public void func(TreeNode root, int[][] matrix, int i, int j) {
        if (root == null) return;
        matrix[i][j] = root.val;
        func(root.left, matrix, i + 1, j - (int) Math.pow(2, height - i - 1));
        func(root.right, matrix, i + 1, j + (int) Math.pow(2, height - i - 1));
    }
}
