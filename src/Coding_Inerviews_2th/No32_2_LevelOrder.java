package Coding_Inerviews_2th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No32_2_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tmp = queue.poll();
                cur.add(tmp.val);
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
            ans.add(cur);
        }
        return ans;
    }
}
