package Period.January_2022;

public class No1688_NumberOfMatches {
    public int numberOfMatches(int n){
        int count = 0;
        while(n>1){
            count += n&1;
            n /= 2;
            count += n;
        }
        return count;
    }
}
