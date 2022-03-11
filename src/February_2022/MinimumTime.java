package February_2022;

public class MinimumTime {
    public int minimumTime(String s){
        int len = s.length();
        int[] left = new int[len+1];
        int[] right = new int[len+1];
        for(int i=1;i<=len;i++) left[i] = s.charAt(i-1)=='0'?left[i-1]:Math.min(left[i-1]+2,i);
        for(int i=1;i<=len;i++) right[len-i] = s.charAt(i-1)=='0'?right[len-i+1]:Math.min(right[len-i+1]+2,i);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<=len;i++) res = Math.min(res,left[i]+right[len-i]);
        return res;
    }
}
