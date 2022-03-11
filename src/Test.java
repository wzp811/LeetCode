import java.util.*;
public class Test{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
            System.out.println(i+": ");
            for (Character key : map.keySet()) {
                System.out.print(key+" ");
                System.out.println(map.get(key));
            }
            int []num = new int [9];
            System.out.println("--------------------");
        }
    }
}