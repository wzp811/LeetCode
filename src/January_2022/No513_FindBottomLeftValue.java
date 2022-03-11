package January_2022;

import java.util.LinkedList;
import java.util.Queue;

public class No513_FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            node = queue.poll();
            res = node.val;
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return res;
    }
}
