package Period.September_2021;
import java.util.*;

public class No383_CanConstruct {
    public static void main(String[] args) {
        No383_CanConstruct ex = new No383_CanConstruct();
        Scanner input = new Scanner(System.in);
        String ransomNote = input.nextLine();
        String magazine = input.nextLine();
        System.out.println(ex.canConstruct(ransomNote,magazine));
    }
    public boolean canConstruct1(String ransomNote,String magazine){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }else{
                map.put(magazine.charAt(i),1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(map.containsKey(ransomNote.charAt(i))) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
                if (map.get(ransomNote.charAt(i)) == 0) {
                    map.remove(ransomNote.charAt(i));
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean canConstruct(String ransomNote,String magazine){
        int []count = new int [26];
        for(int i=0;i<26;i++){
            count[i] = 0;
        }
        for(int i=0;i<magazine.length();i++){
            count[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(count[ransomNote.charAt(i)-'a']!=0){
                count[ransomNote.charAt(i)-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
