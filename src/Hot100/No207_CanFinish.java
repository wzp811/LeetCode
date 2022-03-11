package Hot100;

import java.util.*;

public class No207_CanFinish {
    public boolean canFinish1(int numCourses,int[][] prerequisites){
        HashMap<Integer,Queue<Integer>> map = new HashMap<Integer, Queue<Integer>>();
        for(int i=0;i<prerequisites.length;i++){
            Queue<Integer> tmp = map.getOrDefault(prerequisites[i][0],new LinkedList<>());
            tmp.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],tmp);
        }
        for(int i=0;i<numCourses;i++){
            HashSet<Integer> set = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            int cur = i;
            stack.push(cur);
            set.add(cur);
            while(!stack.isEmpty()){
                if(map.containsKey(cur)){
                    Queue<Integer> tmp = map.get(cur);
                    int next = tmp.poll();
                    if(tmp.isEmpty()) map.remove(cur);
                    else map.put(cur,tmp);
                    cur = next;
                    if(set.contains(cur)) return false;
                    set.add(cur);
                    stack.push(cur);
                }else{
                    set.remove(cur);
                    stack.pop();
                    cur = stack.peek();
                }

            }
        }
        return true;
    }
}
