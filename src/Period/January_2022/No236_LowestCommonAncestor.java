package Period.January_2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class No236_LowestCommonAncestor {
    public class Info{
        public TreeNode ans;
        public boolean findp;
        public boolean findq;
        Info(TreeNode aval,boolean b1,boolean b2){
            ans = aval;
            findp = b1;
            findq = b2;
        }
    }
    public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        return process(root,p,q).ans;
    }
    public Info process(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return new Info(null,false,false);
        Info leftInfo = process(root.left,p,q);
        Info rightInfo = process(root.right,p,q);
        boolean findP = root==p|| leftInfo.findp|| rightInfo.findp;
        boolean findQ = root==q|| leftInfo.findq|| rightInfo.findq;
        TreeNode ans = null;
        if(leftInfo.ans!=null) ans = leftInfo.ans;
        if(rightInfo.ans!=null) ans = rightInfo.ans;
        if(ans==null&&findP&&findQ) ans = root;
        return new Info(ans,findP,findQ);
    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        HashMap<TreeNode,TreeNode> father = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur.left!=null){
                stack.push(cur.left);
                father.put(cur.left,cur);
            }
            if(cur.right!=null){
                stack.push(cur.right);
                father.put(cur.right,cur);
            }
        }
        HashSet<TreeNode> passed = new HashSet<>();
        cur = p;
        while(father.containsKey(cur)){
            passed.add(cur);
            cur = father.get(cur);
        }
        cur = q;
        while(father.containsKey(cur)){
            if(passed.contains(cur)) return cur;
            passed.add(cur);
            cur = father.get(cur);
        }
        return root;
    }
}
