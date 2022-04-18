package QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;

public class No386_LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        process(res, n, 1);
        return res;
    }
    public void process(List<Integer> res, int n, int cur) {
        for (int i = 0; i < 10; i++) {
            int num = cur * 10 + i;
            if (num <= n) {
                res.add(num);
                process(res, n, num);
            }
        }
    }
}
