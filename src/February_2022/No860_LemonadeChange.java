package February_2022;

public class No860_LemonadeChange {
    public boolean lemonadeChange(int[] bills){
        int fiveCount = 0;
        int tenCount = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fiveCount++;
            }else if(bills[i]==10){
                fiveCount--;
                tenCount++;
                if(fiveCount<0) return false;
            }else if(bills[i]==20){
                if(tenCount>0) tenCount--;
                else if(fiveCount>=3) fiveCount -= 2;
                else return false;
                fiveCount--;
                if(tenCount<0||fiveCount<0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No860_LemonadeChange obj = new No860_LemonadeChange();
//        int[] bills = new int[]{5,5,5,10,20};
//        int[] bills = new int[]{5,5,10};
        int[] bills = new int[]{10,10};
//        int[] bills = new int[]{5,5,10,10,20};
        System.out.println(obj.lemonadeChange(bills));
    }
}
