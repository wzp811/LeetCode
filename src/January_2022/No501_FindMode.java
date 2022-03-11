package January_2022;

import java.util.*;

public class No501_FindMode {
    public int[] findMode(TreeNode root){
        HashMap<Integer,Integer> count = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        stack.push(root);
        TreeNode cur = root.left;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();

                int c = count.getOrDefault(cur.val,new Integer(0));
                c++;
                count.put(cur.val,c);
                if(c>max){
                    res.clear();
                    max = c;
                    res.add(cur.val);
                }else if(c==max){
                    res.add(cur.val);
                }

                cur = cur.right;
            }
        }
        int[] arr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
