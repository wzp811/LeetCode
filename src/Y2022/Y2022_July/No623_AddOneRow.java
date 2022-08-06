package Y2022.Y2022_July;

import Coding_Interviews.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No623_AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        TreeNode cur = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(cur);
        for (int i = 0; i < depth; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                if (i == depth - 1) {
                    TreeNode ll = new TreeNode(val);
                    TreeNode rr = new TreeNode(val);
                    ll.left = node.left;
                    rr.right = node.right;
                    node.left = ll;
                    node.right = rr;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间
    }
}
