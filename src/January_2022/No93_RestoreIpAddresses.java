package January_2022;

import com.sun.javaws.IconUtil;

import java.util.LinkedList;
import java.util.List;

public class No93_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s){
        int len = s.length();
        List<String> res = new LinkedList<>();
        if(len<4||len>12) return res;
        char[] cur = new char[len+3];
        calc(s,0,0,res,cur);
        return res;
    }
    public void calc(String s,int index,int off,List<String> res,char[] cur){
        if(off==3){
            for(int i=index;i<s.length();i++) cur[i+off] = s.charAt(i);
            if(Integer.valueOf(new String(cur,index+off,s.length()-index))>255||s.charAt(index)=='0'&&index+1<s.length()) return;
            String tmp = new String(cur);
            res.add(tmp);
            return;
        }
        if(index==s.length()) return;
        for(int i=index;i<Math.min(s.length()-(3-off),index+3);i++){
            if(!(s.charAt(index)=='0'&&i>index)) {
                cur[i + off] = s.charAt(i);
                if((Integer.valueOf(new String(cur,index+off,i-index+1))<=255)) {
                    cur[i + off + 1] = '.';
                    calc(s, i + 1, off + 1, res, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        No93_RestoreIpAddresses obj = new No93_RestoreIpAddresses();
        System.out.println(obj.restoreIpAddresses("101023"));
    }
}
