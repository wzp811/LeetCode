package Coding_Inerviews_2th;

import java.util.Arrays;
import java.util.Stack;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "-";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node==null){
                sb.append("-,");
                continue;
            }else{
                sb.append(String.valueOf(node.val)+',');
            }
            stack.push(node.right);
            stack.push(node.left);
        }
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]k = data.split(",");
        if(k.length==1) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(k[0]));
        stack.push(root);
        int index = 1;
        TreeNode cur = null;
        while(index<data.length()){
            if(k[index].equals("-")){
                if(stack.isEmpty()) return root;
                while(stack.peek().right!=null) stack.pop();
                cur = stack.pop();
            }else{
                if(cur==null){
                    cur = new TreeNode(Integer.parseInt(k[index]));
                    stack.peek().left = cur;
                }else{
                    cur.right = new TreeNode(Integer.parseInt(k[index]));
                    cur = cur.right;
                }
                stack.push(cur);
                cur = null;
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        String tmp = "1 1 1 ";
        System.out.println(Arrays.toString(tmp.split(" ")));
    }
}