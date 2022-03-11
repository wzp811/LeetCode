package Coding_Inerviews_2th;

import java.util.HashMap;

public class No07_BuildTree {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        TreeNode root = process(preorder,inorder,
                0,preorder.length-1,0,inorder.length-1,map);
        return root;
    }
    public TreeNode process(int[] preorder,int[] inorder
            ,int preLeft,int preRight,int inLeft,int inRight,HashMap<Integer,Integer> map){
        if(preLeft>preRight||inLeft>inRight) return null;
        int val = preorder[preLeft];
        int inIndex = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(val);

        root.left = process(preorder,inorder,preLeft,(inIndex-1-inLeft+1)+preLeft,inLeft,inIndex-1,map);
        root.right = process(preorder,inorder,((inIndex-1-inLeft+1)+preLeft)+1,preRight,inIndex+1,inRight,map);

        return root;
    }
}
