package Period.January_2022;

import java.util.LinkedList;
import java.util.List;

public class No222_CountNodes {
    public int countNodes1(TreeNode root){
        if(root==null)  return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int countNodes(TreeNode root){
        int depth = 0;
        TreeNode node = root;
        if(root==null) return depth;
        while(node.left!=null){
            depth++;
            node = node.left;
        }
        if(depth==0) return 1;
        int L = (int)Math.pow(2,depth);
        int R = (int)Math.pow(2,depth+1);
        int M = 0;
        while(L<R){
            M = L+((R-L)>>1);
            if(existNode(root,M,depth)){
                L = M+1;
            }else{
                R = M;
            }
        }
        return L-1;
    }
    public boolean existNode(TreeNode root,int path,int depth){
        int tmp = 1<<(depth-1);
        while(tmp!=0){//!!!!!!
            if((path&tmp)==0){
                root = root.left;
            }else{
                root = root.right;
            }
            tmp>>=1;
        }
        return root!=null;
    }

    public static void main(String[] args) {
        No222_CountNodes obj = new No222_CountNodes();
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        TreeNode root = TreeNode.createTree(l);
        System.out.println("res:"+obj.countNodes(root));
    }
}
