package Hot100;

public class No33_Search {
    public int search1(int[] nums,int target){
        int len = nums.length;
        if(len==1) return target==nums[0]?0:-1;
        int left = 0;
        int right = len-1;
        int mid;
        while(left<right){
            mid = left+((right-left)>>1);
            if(nums[mid]<nums[left]){
                right = mid;
            }else if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                break;
            }
        }
        System.out.println("left: "+left);
        right = left-1+len;
        while(left<right){
            mid = (left+((right-left)>>1));
            if(nums[mid%len]>target) right = mid;
            else if(nums[mid%len]<target) left = mid+1;
            else return mid%len;
        }
        return nums[left]==target?left:-1;
    }

    public int search(int[] nums,int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<right){
            int mid = left+((right-left)>>1);
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[left]){
                if(target>=nums[left]&&target<=nums[mid]) right = mid;
                else left = mid+1;
            }else{
                if(target>=nums[mid+1]&&target<=nums[right]) left = mid+1;
                else right = mid;
            }
        }
        return nums[left]==target?left:-1;
    }

    public static void main(String[] args) {
        No33_Search obj = new No33_Search();
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{1};
//        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
//        int[] nums = new int[]{9,10,11,12,13,14,15,4,5,6,7,8};
        System.out.println(obj.search(nums,1));
    }
}
