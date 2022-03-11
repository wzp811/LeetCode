package January_2022;

import java.util.Stack;

public class No450_DeleteNode {
    public TreeNode deleteNode(TreeNode root,int key){
        if(root==null) return root;
        root = delete(root,key);
        return root;
    }
    public TreeNode delete(TreeNode root, int key) {
        if(root.val==key){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode cur = root.right;
            while(cur.left!=null) cur = cur.left;
            cur.left = root.left;
            return root.right;
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
