package Hot100;

public class No283_MoveZeroes {
    public void moveZeroes(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++) nums[i] = nums[i+1];
                nums[nums.length-1] = 0;
                i--;
            }
        }


        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++) nums[i] = nums[i+1];
                nums[nums.length-1] = 0;
            }
        }

        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) nums[index++] = nums[i];
        }
        for(int i=index;i<nums.length;i++) nums[i] = 0;
    }
}
