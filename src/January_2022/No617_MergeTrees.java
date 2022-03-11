package January_2022;

public class No617_MergeTrees {
    public TreeNode mergeTrees1(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return null;
        if(root1!=null&&root2!=null){
            TreeNode node = new TreeNode(root1.val+root2.val);
            node.left = mergeTrees1(root1.left,root2.left);
            node.right = mergeTrees1(root1.right,root2.right);
            return node;
        }
        TreeNode node = new TreeNode(root1!=null?root1.val:root2.val);
        if(root1!=null){
            node.left = mergeTrees1(root1.left,null);
            node.right = mergeTrees1(root1.right,null);
        }else{
            node.left = mergeTrees1(null,root2.left);
            node.right = mergeTrees1(null,root2.right);
        }
        return node;
    }
    public TreeNode mergeTrees(TreeNode root1,TreeNode root2){
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode node = new TreeNode(root1.val+root2.val);
        node.left = mergeTrees(root1.left,root2.left);
        node.right = mergeTrees(root1.right,root2.right);
        return node;
    }
}
