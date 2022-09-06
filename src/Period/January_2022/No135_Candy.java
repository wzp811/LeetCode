package Period.January_2022;

import java.util.Arrays;

public class No135_Candy {
    public int candy(int[] ratings){
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy,1);
        for(int i=1;i<len;i++){
            candy[i] = ratings[i]>ratings[i-1]?candy[i-1]+1:1;
        }
        for(int i=len-2;i>=0;i--){
            candy[i] = ratings[i]>ratings[i+1]?Math.max(candy[i+1]+1,candy[i]):Math.max(1,candy[i]);
        }
        int sum = 0;
        for(int i=0;i<len;i++) sum += candy[i];
        return sum;
    }

    public static void main(String[] args) {
        No135_Candy obj = new No135_Candy();
//        int[] ratings = new int[]{1,3,2,2,1};
        int[] ratings = new int[]{1,2,87,87,87,2,1};
//        int[] ratings = new int[]{1,0,2};
//        int[] ratings = new int[]{1,2,2};

        System.out.println(obj.candy(ratings));
    }
}
