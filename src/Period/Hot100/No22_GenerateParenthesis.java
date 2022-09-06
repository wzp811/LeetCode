package Period.Hot100;

import java.util.LinkedList;
import java.util.List;

public class No22_GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        List<String> res = new LinkedList<>();
        process(res,"",0,n);
        return res;
    }
    public void process(List<String> res,String cur,int left,int n){
        if(left==0&&n==0) res.add(cur.toString());
        if(n>0) process(res,cur+'(',left+1,n-1);
        if(left>0) process(res,cur+')',left-1,n);
    }

    public static void main(String[] args) {
        No22_GenerateParenthesis obj = new No22_GenerateParenthesis();
        System.out.println(obj.generateParenthesis(1));
    }
}
