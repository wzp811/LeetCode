package Period.January_2022;

public class No1342_NumberOfSteps {
    public int numberOfSteps(int num){
        int count = 0;
        while(num>0){
            if(num%2==0){
                count++;
                num >>= 1;
            }else{
                count++;
                num -= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No1342_NumberOfSteps obj = new No1342_NumberOfSteps();
        System.out.println(obj.numberOfSteps(0));
    }
}
