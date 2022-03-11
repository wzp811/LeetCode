package January_2022;

import java.util.LinkedList;
import java.util.List;

public class No257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new LinkedList<>();
        String path = String.valueOf(root.val);
        if(root.left==null&&root.right==null)
            return res;
        travel(root,path,res);
        return res;
    }
    public void travel(TreeNode root,String path,List<String> res){
        if(root.left==null&&root.right==null){
            res.add(path);
            return;
        }
        if(root.left!=null){
            path += "->"+root.left.val;
            travel(root.left,path,res);
        }
        if(root.right!=null){
            path += "->"+root.right.val;
            travel(root.right,path,res);
        }
    }
}
