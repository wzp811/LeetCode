package Period.February_2022;

public class No1189_MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text){
        int[] count = new int[5];
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='b') count[0]++;
            else if(text.charAt(i)=='a') count[1]++;
            else if(text.charAt(i)=='l') count[2]++;
            else if(text.charAt(i)=='o') count[3]++;
            else if(text.charAt(i)=='n') count[4]++;
        }
        return Math.min(Math.min(count[0],count[1]),Math.min(Math.min(count[2],count[3])/2,count[4]));
    }
}
