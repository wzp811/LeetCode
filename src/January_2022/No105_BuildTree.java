package January_2022;

import java.util.HashMap;

public class No105_BuildTree {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(inorder[i],i);
        return travel(preorder,0,n-1,inorder,0,n-1,map);
    }
    public TreeNode travel(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright,HashMap<Integer,Integer> map){
        if(inleft>inright)
            return null;
        if(inleft==inright)
            return new TreeNode(inorder[inleft]);
        int val = preorder[preleft];
        int index = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = travel(preorder,preleft+1,index,inorder,inleft,index-1,map);
        node.right = travel(preorder,preleft+index-inleft+1,preright,inorder,index+1,inright,map);
        return node;
    }
}
