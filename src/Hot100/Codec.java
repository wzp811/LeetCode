package Hot100;

import java.util.*;

public class Codec {
    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur==null){
                sb.append("-");
                sb.append(" ");
                continue;
            }else{
                sb.append(String.valueOf(cur.val));
                sb.append(" ");
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] k = data.split(" ");
        if(k.length==1) return null;
        TreeNode root = new TreeNode(Integer.parseInt(k[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                index++;
                if(index<k.length&&!k[index].equals("-")){
                    TreeNode node = new TreeNode(Integer.parseInt(k[index]));
                    cur.left = node;
                    queue.add(node);
                }
                index++;
                if(index<k.length&&!k[index].equals("-")){
                    TreeNode node = new TreeNode(Integer.parseInt(k[index]));
                    cur.right = node;
                    queue.add(node);
                }
            }
        }
        return root;
    }
     */


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        hserialize(root,sb);
        return new String(sb);
    }
    public void hserialize(TreeNode root,StringBuilder sb){
        if(root==null) {
            sb.append("#,");
            return;
        }
        sb.append(String.valueOf(root.val)+",");
        hserialize(root.left,sb);
        hserialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> l = new LinkedList<String>(Arrays.asList(data.split(",")));
        return hdeserialize(l);
    }
    public TreeNode hdeserialize(List<String>l){
        String cur = l.get(0);
        l.remove(0);
        if(cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = hdeserialize(l);
        root.right = hdeserialize(l);
        return root;
    }



    public static void main(String[] args) {
        String str = "12";
        System.out.println(Integer.parseInt(str)+1);
    }
}
