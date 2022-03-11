package January_2022;

import java.util.Arrays;

public class No55_canJump {
    public boolean canJump(int[] nums){
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        visited[0] = true;
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                for(int j=0;j<nums[i];j++){
                    visited[i+j] = true;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
