package QuestionList.Coding_Interviews_2th;

import java.util.ArrayList;
import java.util.List;

public class No34_PathSum {
    public List<List<Integer>> pathSum(TreeNode root,int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        List<Integer> cur = new ArrayList<>();
        process(root,target,ans,cur);
        return ans;
    }
    public void process(TreeNode root,int target,List<List<Integer>> ans,List<Integer> cur){
        cur.add(root.val);
        if(root.left==null&&root.right==null&&root.val==target){
            ans.add(cur);
        }
        if(root.left!=null) process(root.left,target-root.val,ans,cur);
        if(root.right!=null) process(root.right,target-root.val,ans,cur);
        cur.remove(cur.size()-1);
    }
}
