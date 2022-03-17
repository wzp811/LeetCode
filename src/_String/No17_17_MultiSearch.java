package _String;

import com.sun.org.apache.xerces.internal.xs.XSNamedMap;

import java.util.ArrayList;
import java.util.List;

public class No17_17_MultiSearch {
    public int[][] multiSearch(String big, String[] smalls){
        int[][] ans = new int[smalls.length][];
        for(int i=0;i<smalls.length;i++){
            ans[i] = getIndexOf(big, smalls[i]);
        }
        return ans;
    }
    public int[] getNextArray(String match){
        if(match.length()==1) return new int[]{-1};
        int[] next = new int[match.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int x = 0;
        while(i< match.length()){
            if(match.charAt(i-1)==match.charAt(x)){
                next[i++] = ++x;
            }else if(x>0){
                x = next[x];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
    public int[] getIndexOf(String str,String match){
        if(match.length()==0) return new int[0];
        List<Integer> ans = new ArrayList<>();
        int[] next = getNextArray(match);
        int i = 0, j = 0;
        while(i<str.length()){
            if(str.charAt(i)==match.charAt(j)){
                i++;
                j++;
            }else if(j==0){
                i++;
            }else{
                j = next[j];
            }
            if(j==match.length()){
                ans.add(i-j);
                i = i-j+1;
                j = 0;
            }
        }
        int[] res = new int[ans.size()];
        for(i=0;i<ans.size();i++) res[i] = ans.get(i);
        return res;
    }

}

