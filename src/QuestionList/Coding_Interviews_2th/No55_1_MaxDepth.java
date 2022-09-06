package QuestionList.Coding_Interviews_2th;

import java.util.LinkedList;
import java.util.Queue;

public class No55_1_MaxDepth {
    public int maxDepth(TreeNode root){
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
