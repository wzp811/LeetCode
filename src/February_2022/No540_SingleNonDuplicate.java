package February_2022;

public class No540_SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums){
        if(nums.length==1) return nums[0];
        int left = 0;
        int right = nums.length-1;
        int center = (left+right)/2;
        while(left<right){
            if(nums[center]==nums[center-1]){
                if((right-center)%2==0) right = center;
                else left = center+1;
            }else if(nums[center]==nums[center+1]){
                if((center-left)%2==0) left = center;
                else right = center-1;
            }else{
                return nums[center];
            }
            center = (left+right)/2;
        }
        return nums[center];
    }

    public static void main(String[] args) {
        No540_SingleNonDuplicate obj = new No540_SingleNonDuplicate();
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
//        int[] nums = new int[]{3,3,7,7,10,11,11};
        System.out.println(obj.singleNonDuplicate(nums));
    }
}
