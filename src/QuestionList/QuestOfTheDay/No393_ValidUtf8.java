package QuestionList.QuestOfTheDay;

import java.util.Arrays;

public class No393_ValidUtf8 {
    public boolean validUtf8(int[] data){
        int[] digit = new int[]{1<<7,1<<6,1<<5,1<<4,1<<3,1<<2,1};
        System.out.println(Arrays.toString(digit));
        int n = 0;
        for(int i=0;i<data.length;i++){
            if(n==0){
                if((digit[0]&data[i])==0){
                    continue;
                }
                while((digit[n]&data[i])!=0){
                    n++;
                }
                if(n==1||n>4) return false;
                n--;
            }else{
                if((data[i]&digit[0])!=0&&(data[i]&digit[1])==0){
                    n--;
                }else{
                    return false;
                }
            }
            System.out.println(n);
        }
        return n==0;
    }

    public static void main(String[] args) {
        No393_ValidUtf8 obj = new No393_ValidUtf8();
        int[] data = new int[]{197,130,1};
        System.out.println(obj.validUtf8(data));
    }
}
