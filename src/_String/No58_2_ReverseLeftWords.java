package _String;

public class No58_2_ReverseLeftWords {
    public String reverseLeftWords(String s,int n){
        StringBuilder sb = new StringBuilder();
        for(int i=n;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
