package QuestionList.Coding_Interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No113_FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int right = prerequisite[1];
            int left = prerequisite[0];
            inDegree[left]++;
            Set<Integer> tmpSet = map.getOrDefault(right, new HashSet<>());
            tmpSet.add(left);
            map.put(right, tmpSet);
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (index < numCourses) {
            boolean ok = false;
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    ok = true;
                    inDegree[i]--;
                    res[index++] = i;
                    if (map.containsKey(i)) {
                        Set<Integer> tmpSet = map.get(i);
                        for (int next : tmpSet) {
                            inDegree[next]--;
                        }
                    }
                }
            }
            if (!ok && index < numCourses) return new int[0];
        }
        return res;
    }
}
