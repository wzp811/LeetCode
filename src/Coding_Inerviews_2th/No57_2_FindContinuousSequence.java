package Coding_Inerviews_2th;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class No57_2_FindContinuousSequence {
    public int[][] findContinuousSequence(int target){
        List<int[]> ans = new ArrayList<>();
        int i = 1,j = 2;
        while(i+j<target){
            int sum = (i+j)*(j-i)/2;
            if(sum==target){
                int[]cur = new int[j-i+1];
                for(int p=i;p<=j;p++) cur[p-i] = p;
            }else if(sum>target){
                i++;
            }else if(sum<target){
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
