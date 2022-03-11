package Coding_Interviews_2th;

public class No67_StrToInt {
    public int strToInt(String str) {
        int ans = 0;
        boolean isNega = false;
        boolean begin = false;
        int boundry = Integer.MAX_VALUE/10;
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                begin = true;
                if(ans > boundry || ans==boundry && (int)(str.charAt(i)-'0') > 7)
                    return isNega?Integer.MIN_VALUE:Integer.MAX_VALUE;
                ans *= 10;
                ans += (int)(str.charAt(i)-'0');
            }else if(str.charAt(i)=='-'||str.charAt(i)=='+'){
                if(begin) break;
                isNega = str.charAt(i)=='-'?true:false;
                begin = true;
            }else{
                if(begin||str.charAt(i)!=' ') break;
            }
        }
        return isNega?-ans:ans;
    }
}
