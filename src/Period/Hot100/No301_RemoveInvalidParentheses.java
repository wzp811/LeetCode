package Period.Hot100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No301_RemoveInvalidParentheses {
    HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s){
        List<String> res = new LinkedList<>();
        for(int i=0;i<=s.length();i++){
            StringBuilder sb = new StringBuilder();
            process(s,sb,res,i,0,0,0);
            if(!res.isEmpty()) return res;
        }
        return res;
    }
    public void process(String s,StringBuilder sb,List<String> res,int k,int index,int left,int right){
        if(index>=s.length()&&k==0&&left==right) {
            String cur = new String(sb);
            if(!set.contains(cur)) {
                res.add(cur);
                set.add(cur);
            }
        }
        if(index>=s.length()||left-right>s.length()-index) return;
        if((s.charAt(index)=='('||s.charAt(index)==')')&&k>0) process(s,sb,res,k-1,index+1,left,right);
        if(k<s.length()-index) {
            if(s.charAt(index)=='(') left++;
            else if(s.charAt(index)==')') right++;
            if(right>left) return;
            sb.append(s.charAt(index));
            process(s, sb, res, k, index + 1,left,right);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public boolean check(StringBuilder sb){
        int left = 0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='('){
                left++;
            }else if(sb.charAt(i)==')'){
                left--;
            }
            if(left<0) return false;
        }
        return left==0;
    }

    public static void main(String[] args) {
        No301_RemoveInvalidParentheses obj = new No301_RemoveInvalidParentheses();
//        System.out.println(obj.removeInvalidParentheses("()())()"));
//        System.out.println(obj.removeInvalidParentheses("(a)())()"));
        System.out.println(obj.removeInvalidParentheses(")("));
    }
}
