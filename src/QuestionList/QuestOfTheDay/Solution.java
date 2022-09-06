package QuestionList.QuestOfTheDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {
    HashMap<Integer, List<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> curList = map.getOrDefault(nums[i], new ArrayList<>());
            curList.add(i);
            map.put(nums[i], curList);
        }
    }

    public int pick(int target) {
        List<Integer> curList = map.get(target);
        int randomIndex = random.nextInt(curList.size());
        return curList.get(randomIndex);
    }
}
