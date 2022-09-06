package QuestionList.Coding_Interviews;

public class No117_NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[][] isConnected = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String str1 = strs[i], str2 = strs[j];
                if (str1.length() != str2.length()) continue;
                int cnt = 0;
                int[] index = new int[2];
                for (int k = 0; k < str1.length(); k++) {
                    if (str1.charAt(k) != str2.charAt(k)) {
                        if (cnt == 2) {
                            cnt++;
                            break;
                        }
                        index[cnt++] = k;
                    }
                }
                if (cnt != 2 && cnt != 0) continue;
                isConnected[i][j] = true;
            }
        }
        int[] father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j]) {
                    union(father, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) if (father[i] == i) cnt++;
        return cnt;
    }

    public void union(int[] father, int i, int j) {
        father[find(father, i)] = find(father, j);
    }

    public int find(int[] father, int i) {
        if (father[i] != i) {
            father[i] = find(father, father[i]);
        }
        return father[i];
    }
}
