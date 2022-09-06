package QuestionList.Coding_Interviews_2th;

import java.util.*;

public class No38_Permutation {
    public String[] permutation(String s){
        List<String> ans = new ArrayList<>();
        char[] ch = new char[s.length()];
        boolean[] help = new boolean[s.length()];
        Arrays.fill(help,false);
        process(s,ch,0,ans,0,help);
        return ans.toArray(new String[0]);
    }
    public void process(String s,char[] ch,int cindex,List<String> ans,int index,boolean[]help){
        if(index==s.length()) ans.add(new String(ch));
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(index))&&!help[index]){
                set.add(s.charAt(index));
                ch[cindex] = s.charAt(index);
                help[index] = true;
                process(s,ch,cindex+1,ans,index+1,help);
                help[index] = false;
            }
        }
    }
}
