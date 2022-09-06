package Period.February_2022;

public class No553_OptimalDivision {
    public String optimalDivision(int[] nums){
        if(nums.length==1) return String.valueOf(nums[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[0]));
        for(int i=1;i<nums.length;i++){
            if(i==1) sb.append("/");
            if(i==1&&nums.length>2) sb.append("(");
            sb.append(String.valueOf(nums[i]));
            if(i!=nums.length-1) sb.append("/");
            if(i==nums.length-1&&nums.length>2) sb.append(")");
        }
        return new String(sb);
    }
}
