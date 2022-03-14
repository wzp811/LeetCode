package _String;

public class No05_ReplaceSpace {
    public String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)==' '?"%20":s.charAt(i));
        }
        return sb.toString();
    }
}
