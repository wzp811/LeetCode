package QuestionList.Coding_Interviews_2th;

public class No43_CountDigitOne {
    public int countDigitOneShit(int n){
        int digit = 1;
        int ans = 0;
        while(digit<=n){
            int low = n%digit;
            int high = n/(digit*10);
            if(n/digit%10==0){
                System.out.println("0:\t"+(high*digit));
                ans += high*digit;
            }else if(n/digit%10==1){
                System.out.println("1:\t"+(high*digit+low+1));
                ans += high*digit+low+1;
            }else if(n/digit%10>1){
                System.out.println("2:\t"+((high+1)*digit));
                ans += (high+1)*digit;
            }
            System.out.println("digit: "+digit+"\t\t\thigh: "+high+"\t\tlow: "+low+"\t\tcur: "+n/digit%10+"\t\tans: "+ans);
            System.out.println();
            if(digit>=n/10) break;
            digit *= 10;
        }
        return ans;
    }

    public int countDigitOne(int n){
        int cur = n%10;
        int high = n/10;
        int low = n%1;
        int digit = 1;
        int ans = 0;
        while(high>0||cur!=0){
            if(cur==0) ans += high*digit;
            else if(cur==1) ans += high*digit+low+1;
            else ans += (high+1)*digit;
            digit *= 10;
            cur = high%10;
            high /= 10;
            low = n%digit;
        }
        return ans;
    }

    public static void main(String[] args) {
        No43_CountDigitOne obj = new No43_CountDigitOne();
        System.out.println(obj.countDigitOne(1410065408));
    }
}
