package February_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No521_FindLUSlength {
    public int findLUSlength(String a,String b){
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }

    public static void main(String[] args) {
        No521_FindLUSlength obj = new No521_FindLUSlength();
        System.out.println(obj.findLUSlength("aefawfawfawfaw","aefawfeawfwafwaef"));
    }
}
