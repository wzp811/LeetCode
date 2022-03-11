package Coding_Interviews_2th;

public class No20_IsNumber {
    public boolean isNumber(String s){
        // 用于判定空格
        boolean began = false;
        boolean end = false;
        // 用于判定e
        boolean afterE = false;

        boolean pointed = false;
        boolean signal = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(began) end = true;
            }else{
                began = true;
                if(end) return false;
            }
            if(s.charAt(i)=='e'||s.charAt(i)=='E'){
                if(i==0||i==s.length()-1||s.charAt(i-1)==' '||s.charAt(i+1)==' ') return false;
                if(afterE) return false;
                afterE = true;
                signal = false;
                pointed = true;
            }
            if(s.charAt(i)=='.'){
                signal = true;
                if(pointed) return false;
                pointed = true;
                if(!(i<s.length()-1&&Character.isDigit(s.charAt(i+1))||i>0&&Character.isDigit(s.charAt(i-1)))) return false;
            }
            if(Character.isDigit(s.charAt(i))){
                signal = true;
            }
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                if(signal) return false;
                signal = true;
                if(!afterE&&pointed) return false;
                if(i==s.length()-1||!(s.charAt(i+1)=='.'||Character.isDigit(s.charAt(i+1)))||i>0&&Character.isDigit(s.charAt(i-1))) return false;
            }
            if(!(Character.isDigit(s.charAt(i))||s.charAt(i)==' '||s.charAt(i)=='.'||s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='e'||s.charAt(i)=='E')) return false;
        }
        return began;
    }
}

