package February_2022;

public class No968_MinCameraCover {
    int count = 0;
    public int minCameraCover(TreeNode root){
        int tmp = travel(root);
        if(tmp==0) count++;
        return count;
    }
    // 0：无相机无监控 1：无相机有监控    2：有相机
    public int travel(TreeNode root){
        if(root==null) return -1;
        int left = travel(root.left);
        int right = travel(root.right);
        if(left==0||right==0){       //至少一个没监控
            count++;
            return 2;
        }else if(left+right>=3){    //两个都有监控且至少一个相机
            return 1;
        }else if(left==1&&right==1){ //两边都没相机有监控
            return 0;                //如果是头，返回0 结果再加一
        }else if(left==-1&&right==-1){//叶子节点
            return 0;
        }else if(left==-1||right==-1){
            return left==-1?right-1:left-1;
        }
        return -1;
    }
}
