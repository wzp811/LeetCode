package February_2022;

import java.util.Arrays;

public class No2055_PlatesBetweenCandles {
    public int[] platesBetweenCandles1(String s,int[][] queries){
        int []right = new int[s.length()];
        int lastRight = s.length();
        for(int i=s.length()-1;i>=0;i--){
            right[i] = lastRight;
            if(s.charAt(i)=='|'){
                lastRight = i;
            }
        }
        System.out.println(Arrays.toString(right));
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            l = s.charAt(l)!='|'?right[queries[i][0]]:queries[i][0];
            int cnt = 0, r = l;
            System.out.println(l+" "+r);
            while(right[r]<=queries[i][1]){
                cnt++;
                r = right[r];
                System.out.println(cnt+" "+r);
            }
            ans[i] = r-l-cnt;
            System.out.println();
        }
        return ans;
    }

    public int[] platesBetweenCandles(String s,int[][] queries){
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] prefix = new int[s.length()];
        int lastLeft = -1, lastRight = s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                prefix[i] = prefix[Math.max(lastLeft,0)]+1;
                lastLeft = i;
            }
            if(s.charAt(s.length()-1-i)=='|'){
                lastRight = s.length()-1-i;
            }
            left[i] = lastLeft;
            right[s.length()-1-i] = lastRight;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(prefix));
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            l = s.charAt(l)=='|'?l:right[l];
            int r = queries[i][1];
            r = s.charAt(r)=='|'?r:left[r];
            if(l>=r) ans[i] = 0;
            else ans[i] = r-l-(prefix[r]-prefix[l]);
        }
        return ans;
    }

    public static void main(String[] args) {
        No2055_PlatesBetweenCandles obj = new No2055_PlatesBetweenCandles();
        int[][] queries = new int[][]{{1,17},{2,17},{3,17},{4,5},{14,17},{5,11},{15,16}};
//        int[][] queries = new int[][]{{2,5},{5,9}};
//        System.out.println(Arrays.toString(obj.platesBetweenCandles("**|**|***|",queries)));
        System.out.println(Arrays.toString(obj.platesBetweenCandles("***|**|*****|**||**|*",queries)));
    }
}
