package Coding_Interviews_2th;

public class No05_ReplaceSpace {
    public String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}
