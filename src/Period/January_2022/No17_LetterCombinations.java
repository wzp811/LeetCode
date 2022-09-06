package Period.January_2022;

import java.util.LinkedList;
import java.util.List;

public class No17_LetterCombinations {
    char[] low = new char[]{' ',' ','a','d','g','j','m','p','t','w'};
    char[] high = new char[]{' ',' ','c','f','i','l','o','s','v','z'};
    public List<String> letterCombinations(String digits){
        int len = digits.length();
        if(len==0) return null;
        List<String> res = new LinkedList<>();
        char[]cur = new char[digits.length()];
        combine(digits,0,res,cur);
        return res;
    }
    public void combine(String digits,int index,List<String> res,char[] cur){
        if(index>=digits.length()){
            String cpy = new String(cur);
            res.add(cpy);
            return;
        }
        for(char c = low[Integer.valueOf(digits.charAt(index)-'0')];c<=high[Integer.valueOf(digits.charAt(index)-'0')];c++){
            cur[index] = c;
            combine(digits,index+1,res,cur);
        }
    }

    public static void main(String[] args) {
        No17_LetterCombinations obj = new No17_LetterCombinations();
        obj.letterCombinations("23");
    }
}
