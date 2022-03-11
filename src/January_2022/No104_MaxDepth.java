package January_2022;

import java.util.LinkedList;
import java.util.Queue;

public class No104_MaxDepth {
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int maxDepth1(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return depth;
    }
}
