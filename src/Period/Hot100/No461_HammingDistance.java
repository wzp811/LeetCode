package Period.Hot100;

public class No461_HammingDistance {
    public int hammingDistance(int x,int y){
        int cnt = 0;
        while(x>0||y>0){
            cnt += (x%2)^(y%2);
            x /= 2;
            y /= 2;
        }
        return cnt;
    }
}
