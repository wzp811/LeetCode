package January_2022;

import java.util.LinkedList;
import java.util.Queue;

public class No226_InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return null;
        queue.add(root);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }
        return root;
    }
}
