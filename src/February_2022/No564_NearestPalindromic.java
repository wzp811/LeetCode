package February_2022;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.Arrays;

public class No564_NearestPalindromic {
    public String nearestPalindromic(String n){
        long val = Long.parseLong(n);
        if(n.length()==1) return String.valueOf(val-1);
        int len = n.length();
        long boundary = (long)Math.pow(10,len-1);
        long half = 0;
        for(int i=0;i<(len+1)/2;i++){
            half *= 10;
            half += n.charAt(i)-'0';
        }
        String[] halfs = new String[]{String.valueOf(half-1),String.valueOf(half),String.valueOf(half+1)};
        System.out.println(Arrays.toString(halfs));
        System.out.println(boundary);
        long ans = Integer.MIN_VALUE;
        for(int i=2;i>=0;i--){
            if(Long.valueOf(halfs[i])<0) continue;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<halfs[i].length();j++){
                sb.append(halfs[i].charAt(j));
            }
            for(int j=0;j<halfs[i].length();j++){
                if(len%2==1&&j==0) continue;
                sb.append(halfs[i].charAt(halfs[i].length()-j-1));
            }
            System.out.println("sb: "+sb);
            Long cur = Long.parseLong(new String(sb));
            if(Math.abs(val-cur)<=Math.abs(val-ans)&&cur!=val) ans = cur;
        }
        if(Math.abs(val-(boundary-1))<=Math.abs(val-ans)) ans = boundary-1;
        System.out.println("boundary: "+(boundary-1)+" "+(boundary*10+1));
        if(Math.abs(val-(boundary*10+1))<Math.abs(val-ans)) ans = boundary*10+1;
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        No564_NearestPalindromic obj = new No564_NearestPalindromic();
        System.out.println(obj.nearestPalindromic("11911"));
    }
}
