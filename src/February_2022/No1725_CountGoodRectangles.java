package February_2022;

public class No1725_CountGoodRectangles {
    public int countGoodRectangles(int[][] rectangles){
        int count = 0;
        int maxlen = 0;
        for(int i=0;i<rectangles.length;i++){
            int len = Math.min(rectangles[i][0],rectangles[i][1]);
            if(maxlen<len){
                maxlen = len;
                count = 0;
            }else if(maxlen==len){
                count++;
            }
        }
        return count;
    }
}
