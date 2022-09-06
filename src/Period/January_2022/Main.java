package Period.January_2022;

import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public int getMostNum(int []x,int []y){
        int n = x.length;
        HashMap<Integer,Integer> belong = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=1;i<n;i++){
            belong.put(x[i],x[i]);
            belong.put(y[i],y[i]);
            count.put(x[i],1);
            count.put(y[i],1);
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int head = x[i];
            while(head!=belong.get(head)){
                head = belong.get(head);
            }
            belong.put(y[i],head);
            count.put(head,count.get(head)+count.get(y[i]));
            if(count.get(head)>max)
                max = count.get(head);
        }
        return max;
    }
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int i=0;i<T;i++){
            int n = input.nextInt();
            int []x = new int[n+1];
            int []y = new int[n+1];
            for(int j=1;j<=n;j++){
                x[j] = input.nextInt();
                y[j] = input.nextInt();
            }
            Main obj = new Main();
            System.out.println(obj.getMostNum(x,y));
        }
    }
}