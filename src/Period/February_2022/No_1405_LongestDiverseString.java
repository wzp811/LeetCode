package Period.February_2022;

import java.util.*;

public class No_1405_LongestDiverseString {
    public String longestDiverseString(int a,int b,int c){
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->y[0]-x[0]);
        if(a!=0) queue.add(new int[]{a,0});
        if(b!=0) queue.add(new int[]{b,1});
        if(c!=0) queue.add(new int[]{c,2});
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            char curCh = (char)('a'+cur[1]);
            if(len<2||sb.charAt(len-1)!=curCh||sb.charAt(len-2)!=curCh){
                sb.append(curCh);
                cur[0]--;
                len++;
            }else{
                if(queue.size()==0) break;
                int[] tmp = queue.poll();
                sb.append((char)('a'+tmp[1]));
                tmp[0]--;
                len++;
                if(tmp[0]!=0) queue.add(tmp);
            }
            if(cur[0]!=0) queue.add(cur);
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        No_1405_LongestDiverseString obj = new No_1405_LongestDiverseString();
        System.out.println(obj.longestDiverseString(7,1,0));
    }
}
