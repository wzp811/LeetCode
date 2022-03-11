package Hot100;

import java.util.HashMap;

public class No437_PathSum {
    public int pathSum1(TreeNode root,int targetSum){
        if(root==null) return 0;
        return travel(root,targetSum);
    }
    // 对每一个节点，都当作头节点进行一次统计
    public int travel(TreeNode root,int targetSum){
        int count = process1(root,targetSum);
        if(root.left!=null) count += travel(root.left,targetSum);
        if(root.right!=null) count += travel(root.right,targetSum);
        return count;
    }
    // 以root为最顶点，向下能够凑到targetSum的路径数 （直到最底）
    public int process1(TreeNode root,int targetSum){
        if(root==null) return 0;
        int count = 0;
        if(targetSum==root.val) count++;
        return process1(root.left,targetSum-root.val)+process1(root.right,targetSum-root.val)+count;
    }
    // 前缀和 每个节点记录从根节点到该节点的和
    // 哈希表存储前缀和为k的节点有多少个
    public int pathSum(TreeNode root,int targetSum){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return process(root,map,targetSum,0);
    }
    public int process(TreeNode root, HashMap<Integer,Integer> map,int targetSum,int his){
        if(root==null) return 0;
        int cnt = map.getOrDefault(root.val+his,new Integer(0));
        int ans = map.getOrDefault(root.val+his-targetSum,new Integer(0));
        map.put(root.val+his,cnt+1);
        ans += process(root.left,map,targetSum,his+root.val);
        ans += process(root.right,map,targetSum,his+root.val);
        // 记得恢复
        map.put(root.val+his,cnt);
        return ans;
    }
}
