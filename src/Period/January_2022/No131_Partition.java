package Period.January_2022;

import java.util.LinkedList;
import java.util.List;

public class No131_Partition {
    public List<List<String>> partition(String s){
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        if(s.length()==0) return res;
        if(s.length()==1) {
            cur.add(s);
            res.add(cur);
            return res;
        }
        char[] str = s.toCharArray();
        calc(str,0,res,cur);
        return res;
    }
    public void calc(char[] str,int index,List<List<String>> res,List<String> cur){
        if(index==str.length){
            List<String> tmp = new LinkedList<>(cur);
            res.add(tmp);
            return;
        }
        int size = cur.size();
        for(int i=index;i<str.length;i++){
            boolean flag = true;
            for(int j=0;j<(i-index+1)/2;j++){
                if(str[index+j]!=str[i-j]) {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            String ss = new String(str,index,i-index+1);
            cur.add(ss);
            calc(str,i+1,res,cur);
            cur.remove(size);
        }
    }

    public static void main(String[] args) {
        No131_Partition obj = new No131_Partition();
        System.out.println(obj.partition("aab"));
    }
}
