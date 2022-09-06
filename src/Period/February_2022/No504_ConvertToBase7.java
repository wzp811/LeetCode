package Period.February_2022;

public class No504_ConvertToBase7 {
    public String convertToBase7(int num){
        StringBuilder sb = new StringBuilder();
        int tmp = Math.abs(num);
        while(tmp>0){
            sb.append((char)(tmp%7+'0'));
            tmp /= 7;
        }
        if(num<0) sb.append('-');
        return new String(sb.reverse());
    }

    public static void main(String[] args) {
        No504_ConvertToBase7 obj = new No504_ConvertToBase7();
        System.out.println(obj.convertToBase7(100));
        System.out.println(obj.convertToBase7(10));
        System.out.println(obj.convertToBase7(-7));
    }
}
