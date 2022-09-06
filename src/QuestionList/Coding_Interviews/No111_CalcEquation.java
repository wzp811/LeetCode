package QuestionList.Coding_Interviews;

import java.util.*;

public class No111_CalcEquation {
    public double[] calcEquation(List<List<String>>equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            HashMap<String, Double> tmp = map.getOrDefault(a, new HashMap<>());
            tmp.put(b, values[i]);
            map.put(a, tmp);
            tmp = map.getOrDefault(b, new HashMap<>());
            tmp.put(a, 1 / values[i]);
            map.put(b, tmp);
        }
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        Set<String> set = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        Deque<Double> doubleQueue = new LinkedList<>();
        for (int i = 0; i < queries.size(); i++) {
            set.clear();
            queue.clear();
            doubleQueue.clear();
            String begin = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!map.containsKey(begin) || !map.containsKey(end)) {
                continue;
            } else if (begin.equals(end)) {
                res[i] = 1.0;
                continue;
            }
            queue.addLast(begin);
            doubleQueue.addLast(1.0);
            set.add(begin);
            boolean canBreak = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String cur = queue.pollFirst();
                    double curDouble = doubleQueue.pollFirst();
                    HashMap<String, Double> curMap = map.get(cur);
                    for (String next : curMap.keySet()) {
                        if (!set.contains(next)) {
                            set.add(next);
                            queue.addLast(next);
                            double curRes = curDouble * curMap.get(next);
                            if (next.equals(end)) {
                                res[i] = curRes;
                                queue.clear();
                                canBreak = true;
                                break;
                            }
                            doubleQueue.addLast(curRes);
                        }
                    }
                    if (canBreak) break;
                }
                if (canBreak) break;
            }
        }
        return res;
    }
}
