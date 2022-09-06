package Period.January_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No491_FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        process(nums,0,res,cur);
        return res;
    }
    public void process(int[] nums,int index,List<List<Integer>> res,List<Integer> cur){
        int size = cur.size();
        if(size>=2) res.add(new LinkedList<>(cur));
        boolean[] visited = new boolean[201];
        Arrays.fill(visited,false);
        for(int i=index;i<nums.length;i++){
            if((index==0||(index>0&&nums[i]>=nums[index-1]))&&!visited[nums[i]+100]){
                visited[nums[i]+100] = true;
                cur.add(nums[i]);
                process(nums,i+1,res,cur);
                cur.remove(size);
            }
        }
    }

    public static void main(String[] args) {
        No491_FindSubsequences obj = new No491_FindSubsequences();
        int[] nums = new int[]{1,6,1,8,1};
        System.out.println(obj.findSubsequences(nums));
    }
}
