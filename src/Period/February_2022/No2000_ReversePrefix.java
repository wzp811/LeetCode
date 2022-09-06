package Period.February_2022;

public class No2000_ReversePrefix {
    public String reversePrefix(String word,char ch){
        int index = -1;
        char[] res = word.toCharArray();
        for(int i=0;i<res.length;i++){
            if(res[i]==ch){
                index = i-1;
                break;
            }
        }
        if(index==-1) return word;
        for(int i=0;i<index/2;i++){
            char tmp = res[i];
            res[i] = res[index-i];
            res[index-i] = tmp;
        }
        return new String(res);
    }
}
