package Period.January_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No47_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        boolean[] help = new boolean[nums.length];
        Arrays.fill(help,false);
        process(nums,0,res,cur,help);
        return res;
    }
    public void process(int[] nums,int index,List<List<Integer>> res,List<Integer> cur,boolean[] help){
        if(index==nums.length){
            res.add(new LinkedList<>(cur));
            return;
        }
        boolean[] visited = new boolean[21];
        Arrays.fill(visited,false);
        int size = cur.size();
        for(int i=0;i<nums.length;i++){
            if(!visited[nums[i]+10]&&!help[i]){
                visited[nums[i]+10] = true;
                cur.add(nums[i]);
                help[i] = true;
                process(nums,index+1,res,cur,help);
                cur.remove(size);
                help[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        No47_PermuteUnique obj = new No47_PermuteUnique();
        int[] nums = new int[]{1,1,2};
        System.out.println(obj.permuteUnique(nums));
    }
}
