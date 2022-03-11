package Coding_Inerviews_2th;

public class No58_1_ReverseWords {
    public String reverseWords(String s){
        String[]k = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=k.length-1;i>=0;i--) {
            if(k[i].equals("")) continue;
            sb.append(k[i]+" ");
        }
        return new String(sb).trim();
    }
}
