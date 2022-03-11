package February_2022;

public class No738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n){
        char[] digit = String.valueOf(n).toCharArray();
        if(digit.length<=1) return n;
        int index = 1;
        while(index<digit.length){
            if(digit[index]<digit[index-1]){
                index -= 1;
                while(index>0&&digit[index]==digit[index-1]) index--;
                digit[index++] -= 1;
                while(index<digit.length) digit[index++] = '9';
            }else{
                index++;
            }
        }
        for(int i=0;i<digit.length;i++) System.out.print(digit[i]);
        System.out.println();
        return Integer.valueOf(new String(digit));
    }

    public static void main(String[] args) {
        No738_MonotoneIncreasingDigits obj = new No738_MonotoneIncreasingDigits();
        System.out.println(obj.monotoneIncreasingDigits(10));
    }
}
