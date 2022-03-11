package February_2022;

public class No258_AddDigits {
    public int addDigits(int num){
        return num==0?0:(num-1)%9+1;
    }
}
