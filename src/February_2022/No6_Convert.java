package February_2022;

public class No6_Convert {
    public String convert(String s,int numRows){
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows&&i<s.length();i++){
            int index = i;
            if(i==0||i==numRows-1){
                while(index<s.length()){
                    sb.append(s.charAt(index));
                    index += 2*numRows-2;
                }
            }else{
                while(index<s.length()){
                    sb.append(s.charAt(index));
                    if((2*index/(2*numRows-2)+1)*(2*numRows-2)-index<s.length()) sb.append(s.charAt((2*index/(2*numRows-2)+1)*(2*numRows-2)-index));
                    index += 2*numRows-2;
                }
            }
        }
        return new String(sb);
    }
}
