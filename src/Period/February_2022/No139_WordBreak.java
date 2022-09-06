package Period.February_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[]dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for(int i=0;i<=s.length();i++){
            System.out.println(i);
            for(int j=0;j<wordDict.size();j++){
                if(i>=wordDict.get(j).length()){
                    System.out.println(s.substring(i-wordDict.get(j).length(),i));
                    if(!dp[i]) dp[i] = s.substring(i-wordDict.get(j).length(),i).equals(wordDict.get(j))?dp[i-wordDict.get(j).length()]:false;
                }
                for(int k=0;k<=s.length();k++) System.out.print(dp[k]+" ");
                System.out.println();
            }
            System.out.println();
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        No139_WordBreak obj = new No139_WordBreak();
        List<String> wordDict = new LinkedList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");

        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(obj.wordBreak("catsandog",wordDict));
    }
}
