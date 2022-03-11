package Coding_Inerviews_2th;

public class No65_Add {
    public int addShit(int a, int b) {
        int ans = 0;
        int index = 1;
        boolean digit = false;
        while((index<a||index<b)||digit) {
            if(digit && (index&a)!=0 && (index&b)!=0){
                digit = true;
                ans |= index;
            }else if(digit && ((index&a)!=0||(index&b)!=0) || (index&a)!=0 && (index&b)!=0) {
                digit = true;
            }else {
                digit = false;
                ans |= index;
            }
            index <<= 1;
        }
        return ans;
    }

    public int add(int a, int b) {
        while(b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
