package Period.January_2022;

import java.util.HashMap;

public class No106_BuildTree {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return travel(inorder,0,n,postorder,0,n,map);
    }
    public TreeNode travel(int[] inorder,int inleft,int inright,int[] postorder,int postleft,int postright,HashMap<Integer,Integer> map){
        if(inright-inleft<1)
            return null;
        if(inright-inleft==1)
            return new TreeNode(inorder[inleft]);
        int rootval = postorder[postright-1];
        int inIndex = map.get(rootval);
        TreeNode node = new TreeNode(rootval);
        node.left = travel(inorder,inleft,inIndex,postorder,postleft,postright-(inright-inIndex),map);
        node.right = travel(inorder,inIndex+1,inright,postorder,postleft+inIndex-inleft,postright,map);
        return node;
    }
    public static void main(String[] args) {
        No106_BuildTree obj = new No106_BuildTree();
        int n = 5;
        int []inorder = new int[]{9,3,15,20,7};
        int []postorder = new int[]{9,15,7,20,3};
        TreeNode root = obj.buildTree(inorder,postorder);
    }
}
