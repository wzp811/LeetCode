package _String;

public class No151_ReverseWords {
    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        int last = s.length();
        boolean append = false;
        for(int i=s.length()-1;i>=-1;i--){
            if(i==-1||s.charAt(i)==' '){
                if(append){
                    for(int j=0;j<(last-i-1);j++){
                        sb.append(s.charAt(i+j+1));
                    }
                    sb.append(' ');
                    append = false;
                }
                last = i;
            }else{
                append = true;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
