package QuestionList.Coding_Interviews_2th;

public class No53_1_Search {
    public int search1(int[] nums,int target){
        return process1(nums,0,nums.length-1,target);
    }
    public int process1(int[] nums,int l,int r,int target){
        if(l>r) return 0;
        if(target<nums[l]||target>nums[r]) return 0;
        if(target==nums[l]&&target==nums[r]) return r-l+1;
        int mid = l+((r-l)>>1);
        int ans = process1(nums,l,mid,target)+process1(nums,mid+1,r,target);
        return ans;
    }

    public int search(int[] nums,int target){
        int l = process(nums,target);
        int r = process(nums,target+1);
        // r最大只能是数组最后一个数，所以不一定能满足nums[r] >= target+1
        // r最大只能是数组最后一个数，所以不一定能满足nums[r] >= target+1
        return nums[r]==target?r-l+1:r-l;
    }
    // 获取第一个大于等于target的下标
    public int process(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+((r-l)>>1);
            if(target<=nums[mid]) r = mid;
            else l = mid+1;
        }
        return l;
    }

}
