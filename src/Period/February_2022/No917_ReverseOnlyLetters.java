package Period.February_2022;

public class No917_ReverseOnlyLetters {
    public String reverseOnlyLetters(String s){
        char[] str = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            while(l<r&&!Character.isLetter(str[l])) l++;
            while(l<r&&!Character.isLetter(str[r])) r--;
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        No917_ReverseOnlyLetters obj = new No917_ReverseOnlyLetters();
        System.out.println(obj.reverseOnlyLetters("7_28]"));
    }
}
