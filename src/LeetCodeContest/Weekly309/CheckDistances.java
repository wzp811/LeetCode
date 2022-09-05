package LeetCodeContest.Weekly309;

public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
        char[] ch = s.toCharArray();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < ch.length; i++) {
            if (visited[ch[i] - 'a']) continue;
            int next = i + 1 + distance[ch[i] - 'a'];
            if (!(next < ch.length && ch[next] == ch[i])) return false;
            visited[ch[i] - 'a'] = true;
        }
        return true;
    }
}
