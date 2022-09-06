package Period.January_2022;

import java.util.Arrays;

public class No455_FindContentChildren {
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length;
        int slen = s.length;
        int gindex = glen-1;
        int sindex = slen-1;
        int count = 0;
        while(gindex>=0&&sindex>=0){
            if(g[gindex]<=s[sindex]){
                count++;
                sindex--;
            }
            gindex--;
        }
        return count;
    }

    public static void main(String[] args) {
        No455_FindContentChildren obj = new No455_FindContentChildren();
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        obj.findContentChildren(g,s);
        for(int i=0;i<g.length;i++) System.out.print(g[i]);
        System.out.println();
        for(int i=0;i<s.length;i++) System.out.print(s[i]);
    }
}
