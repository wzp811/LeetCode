package QuestionList.Coding_Interviews_2th;

public class No44_FindNthDigit {
    public int findNthDigitShit(int n){
        if(n<10) return n;
        int bits = 1;
        int nUsed = 0;
        int digit = 1;
        while(true){
            System.out.println("bits: "+bits);
            System.out.println("nUsed: "+nUsed);
            System.out.println("digit: "+digit);
            if(nUsed+bits*9*digit>=n) {
                // n位于哪个数上
                int num = (n - nUsed - 1) / bits + digit;
                // index的第几位
                int indexOfNum = (n - nUsed - 1) % bits;
                System.out.println("num: "+num);
                System.out.println("index: "+indexOfNum);
                for(int i=indexOfNum;i<bits-1;i++) num /= 10;
                return num%10;
            }
            nUsed += bits*9*digit;
            bits++;
            digit *= 10;
            System.out.println();
        }
    }


    public int findNthDigit(int n){
        int bits = 1;
        long digit = 1;
        while(n-bits*9*digit>0){
            n -= bits*9*digit;
            bits++;
            digit *= 10;
        }
        System.out.println(digit);
        long num = (n-1)/bits+digit;
        int index = (n-1)%bits;
        System.out.println(num+" "+index+" "+bits+" "+digit);
        for(;index<bits-1;index++) num /= 10;
        return (int)num%10;
    }

    public static void main(String[] args) {
        No44_FindNthDigit obj = new No44_FindNthDigit();
//        System.out.println(obj.findNthDigit(2998));
//        System.out.println(obj.findNthDigit(2999));
//        System.out.println(obj.findNthDigit(3000));
//        System.out.println(obj.findNthDigit(3001));
//        System.out.println(obj.findNthDigit(13));
//        System.out.println();
        System.out.println(obj.findNthDigit(1000000000));
//        System.out.println(obj.findNthDigit(1000000001));
//        System.out.println(obj.findNthDigit(1000000002));
//        System.out.println(obj.findNthDigit(1000000003));
//        System.out.println(obj.findNthDigit(1000000004));
//        System.out.println(obj.findNthDigit(1000000005));
    }
}
