package Period.Hot100;

import java.util.*;

public class No621_LeastInterval {
    public int leastInterval(char[] tasks,int n){
        int[][] count = new int[26][2];
        for(int i=0;i<26;i++) count[i][0] = i;
        for(int i=0;i<tasks.length;i++) count[tasks[i]-'A'][1]++;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(int i=0;i<26;i++) if(count[i][1]!=0) pqueue.add(count[i]);
        int cnt = 0;
        int[] wait = new int[26];
        while(!pqueue.isEmpty()){
            Queue<int[]> tmp = new LinkedList<>();
            while((!pqueue.isEmpty())&&wait[pqueue.peek()[0]]!=0){
                tmp.add(pqueue.poll());
            }
            int[] cur;
            if(!pqueue.isEmpty()) {
                cur = pqueue.poll();
                System.out.println(Arrays.toString(cur));
                wait[cur[0]] = n+1;
                cur[1]--;
                if(cur[1]!=0) pqueue.add(cur);
            }else{
                System.out.println("empty");
            }
            while(!tmp.isEmpty()){
                pqueue.add(tmp.poll());
            }
            for(int i=0;i<26;i++) if(wait[i]>0) wait[i]--;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        No621_LeastInterval obj = new No621_LeastInterval();
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(obj.leastInterval(tasks,2));
    }
}
