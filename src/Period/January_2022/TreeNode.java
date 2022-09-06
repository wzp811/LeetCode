package Period.January_2022;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode createTree(List<Integer> l){
        if(l.isEmpty()){return null;}
        TreeNode root;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode temp = new TreeNode(l.get(index++));
        root = temp;
        queue.add(root);
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
        return root;
    }
}
