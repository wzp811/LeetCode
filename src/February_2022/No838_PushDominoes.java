package February_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No838_PushDominoes {
    public String pushDominoes1(String dominoes){
        char[]ch = dominoes.toCharArray();
        int len = dominoes.length();
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(ch[i]=='L') left.add(i);
            else if(ch[i]=='R') right.add(i);
        }
        while(!(left.isEmpty()&&right.isEmpty())){
            char[] cpy = ch.clone();
            int llen = left.size();
            int rlen = right.size();
            for(int i=0;i<llen;i++){
                int cur = left.poll();
                if(cur-1>=0&&cpy[cur-1]=='.'&&(cur==1||cpy[cur-2]!='R')){
                    ch[--cur] = 'L';
                    left.add(cur);
                }
            }
            for(int i=0;i<rlen;i++){
                int cur = right.poll();
                if(cur+1<len&&cpy[cur+1]=='.'&&(cur==len-2||cpy[cur+2]!='L')){
                    ch[++cur] = 'R';
                    right.add(cur);
                }
            }
        }
        return new String(ch);
    }

    public String pushDominoes(String dominoes){
        char[] ch = dominoes.toCharArray();
        int len = dominoes.length();
        char left = 'L', right;
        int i=0;
        while(i<len){
            int j = i;
            while(j<len&&ch[j]=='.') j++;
            right = j==len?'R':ch[j];
            if(left==right){
                while(i<j) ch[i++] = left;
            }else if(left=='R'&&right=='L'){
                int k = j-1;
                while(i<k){
                    ch[i++] = 'R';
                    ch[k--] = 'L';
                }
            }
            left = right;
            i = j+1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        No838_PushDominoes obj = new No838_PushDominoes();
        System.out.println(obj.pushDominoes(".L.R...LR..L.."));
    }
}
