package Coding_Interviews;

import java.util.*;

public class No115_SequenceReconstruction {
    public boolean sequenceReconstructionShit(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] inDegree = new int[org.length + 1];
        Set<Integer> lasts = new HashSet<>();
        for (List<Integer> seq : seqs) {
            lasts.clear();
            for (int curNum : seq) {
                for (int last : lasts) {
                    Set<Integer> tmpSet = map.getOrDefault(last, new HashSet<>());
                    tmpSet.add(curNum);
                    map.put(last, tmpSet);
                    inDegree[curNum]++;
                }
                lasts.add(curNum);
            }
        }
        int index = 0;
        while (index < org.length) {
            List<Integer> tmp = new LinkedList<>();
            int cnt = 0;
            for (int i = 1; i <= org.length; i++) {
                if (inDegree[i] == 0) {
                    if (i != org[index]) return false;
                    index++;
                    inDegree[i]--;
                    cnt++;
                    if (!map.containsKey(i)) continue;
                    Set<Integer> nexts = map.get(i);
                    for (int next : nexts) tmp.add(next);
                }
            }
            if (cnt != 1) return true;
            for (int i : tmp) inDegree[i]--;
        }
        return true;
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] inDegree = new int[n + 1];
        Set<Integer> dict = new HashSet<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() > n) return false;
            for (int num : seq) {
                if (num > n) return false;
                dict.add(num);
            }
        }
        if (dict.size() != n) return false;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(i).size() - 1; j++) {
                graph[seqs.get(i).get(j)].add(seqs.get(i).get(j + 1));
                inDegree[seqs.get(i).get(j + 1)]++;
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int curIndex = queue.poll();
            res.add(curIndex);
            if (org[res.size() - 1] != curIndex) return false;
            for (int next : graph[curIndex]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return res.size() == n;
    }
}
