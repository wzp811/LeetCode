package October_2021;
import java.util.*;

public class No94_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)  return null;
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.peek();
            if(temp.left!=null){
                stack.push(temp.left);
            }else if(temp.right!=null){
                res.add(temp.val);
                stack.pop();
                stack.push(temp.right);
            }else{
                res.add(temp.val);
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    }
}
class TreeNode {
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
