package January_2022;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class No144_145_94_Traversal {
    TreeNode root;
    public No144_145_94_Traversal(){
        root = null;
    }
    //三种遍历的非递归写法
    public class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int v){value = v;};
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }
    public void CreateTreeByLevel(List<Integer> l){
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        if(l.isEmpty()){return;}
        TreeNode temp = new TreeNode(l.get(index++));
        this.root = temp;
        queue.add(this.root);
        while(index<l.size()){
            if(l.get(index)!=null){
                TreeNode tmp = new TreeNode(l.get(index));
                queue.peek().left = tmp;
                queue.add(tmp);
            }
            index++;
            if(index==l.size())  break;
            if(l.get(index)!=null){
                TreeNode tmp = new TreeNode(l.get(index));
                queue.peek().right = tmp;
                queue.add(tmp);
            }
            index++;
            queue.poll();
        }
    }
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        preorderTraversalWithStack(root,res);
        return res;
    }
    public void preorderTraversalWithStack(TreeNode root, List<Integer> res){
        if(root==null)  return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.value);
            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null)    stack.push(temp.right);
        }
    }
    public void preorderTraversal(TreeNode root,List<Integer> res){
        if(root==null)  return;
        res.add(root.value);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
    }
    //后序遍历迭代法 不骚的做法 用两个栈
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Stack<TreeNode>stack1 = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp.value);
            if(temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack1.push(temp.right);
        }
        while(!stack2.isEmpty()){
            res.add(stack2.pop());
        }
        return res;
    }
    //后序遍历迭代法 骚的做法 只用一个栈 用一个当前节点cur和上一个输出的节点last来记录 可以判断该次应该遍历到左节点还是右节点
    public List<Integer> postorderTraversalWithOneStack(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = root;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left!=null&&cur.right!=last&&cur.left!=last){    //cur的左节点还没被遍历过
                stack.push(cur.left);
            }else if(cur.right!=null&&cur.right!=last){             //cur的右节点还没被遍历过
                stack.push(cur.right);
            }else{                                                  //cur为叶子或者cur的左右子树都被遍历了，所以此时打印cur，并让last记录为cur
                res.add(cur.value);
                stack.pop();
                last = cur;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root.left;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur  = stack.pop();
                res.add(cur.value);
                cur = cur.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        No144_145_94_Traversal obj = new No144_145_94_Traversal();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(null);
        l.add(2);
        l.add(3);
        obj.CreateTreeByLevel(l);
        System.out.println(obj.inorderTraversal(obj.root));
    }
}
