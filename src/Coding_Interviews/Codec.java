package Coding_Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return new String(sb);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sb.append(cur == null ? "#" : cur.val);
                sb.append("_");
                if (cur == null) continue;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] k = data.split("_");
        if (k.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(k[0]));
        queue.add(root);
        int index = 1;
        while (index < k.length) {
            TreeNode cur = queue.poll();
            if (!k[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(k[index]));
                cur.left = left;
                queue.add(left);
            }
            index++;
            if (!k[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(k[index]));
                cur.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }
}
