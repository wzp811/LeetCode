package September_2021;
import java.util.*;

public class No242_IsAnagram {
    public static void main(String[] args) {
        No242_IsAnagram ex = new No242_IsAnagram();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        System.out.println(ex.isAnagram(s,t));
    }
    public boolean isAnagram2(String s,String t){
        HashMap<Character,Integer> mapS = new HashMap<Character,Integer>();
        HashMap<Character,Integer> mapT = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(mapS.containsKey(s.charAt(i))){
                mapS.replace(s.charAt(i),mapS.get(s.charAt(i))+1);
            }else{
                mapS.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(mapT.containsKey(t.charAt(i))){
                mapT.replace(t.charAt(i),mapT.get(t.charAt(i))+1);
            }else{
                mapT.put(t.charAt(i),1);
            }
        }
        for(Character c: mapS.keySet()){
            if(!mapS.get(c).equals(mapT.get(c))){
                return false;
            }
        }
        if(mapS.keySet().size()!=mapT.keySet().size()){
            return false;
        }
        return true;
    }
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int []record = new int[26];
        for(int i=0;i<s.length();i++){
            record[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            record[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            record[t.charAt(i)-'a']--;
        }
        for(int i=0;i<s.length();i++){
            if(record[i]!=0){
                return false;
            }
        }
        return true;
    }
}
