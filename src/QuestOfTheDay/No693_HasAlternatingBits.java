package QuestOfTheDay;

public class No693_HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int last = n%2;
        n /= 2;
        while(n > 0) {
            if(last==n%2) return false;
            last = n%2;
            n /= 2;
        }
        return true;
    }
}
