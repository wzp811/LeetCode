package Coding_Interviews_2th;

import java.util.Stack;

public class No33_VerifyPostorder {
    //自己写的递归分治
    public boolean verifyPostorder1(int[] postorder){
        if(postorder.length<3) return true;
        return process(postorder,0,postorder.length-1);
    }
    public boolean process(int[] postorder,int l,int r){
        if(l>r) return true;
        int head = postorder[r];
        int mid = r-1;
        while(mid>=l&&postorder[mid]>=postorder[r]) mid--;
        int check = mid;
        while(check>=l){
            if(postorder[check]>=postorder[r]) return false;
            check--;
        }
        return process(postorder,l,mid)&&process(postorder,mid+1,r-1);
    }
    // 题解的单调栈
    public boolean verifyPostorder(int[] postorder){
        if(postorder.length<3) return true;
        Stack<Integer> stack = new Stack<>();
        int head = Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            if(postorder[i]>head) return false;
            while(!(stack.isEmpty()||stack.peek()<postorder[i])){
                head = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
